package jj.gui;

import jj.core.Message;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.concurrent.atomic.AtomicLong;

class DiagramPanel extends JPanel {

    final static int panelWidth = 150;
    final static int panelHeight = 200;
    final static int border = 10;

    private class PaintPanel extends JPanel {

        PaintPanel() {
            this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        }

        final AtomicLong value = new AtomicLong(0);

        Message lastMessage = null;

        void processMessage(Message message) {
            this.value.set(Double.doubleToLongBits(message.value));
            this.repaint();
            DiagramPanel.this.controlPanel.sequenceField.setText(String.valueOf(message.sequenceNumber));
            if (this.lastMessage != null) {
                long delta = message.sequenceNumber - this.lastMessage.sequenceNumber;
                DiagramPanel.this.controlPanel.deltaField.setText(String.valueOf(delta));
            }
            this.lastMessage = message;
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(DiagramPanel.this.color);
            final int halfHeight = panelHeight / 2;
            final double val = Double.longBitsToDouble(this.value.get());
            final int h = Math.abs((int) (val * halfHeight));
            final int y = val > 0 ? halfHeight - h : halfHeight;
            g.fillRect(border, y, panelWidth - 2 * border, h);
        }
    }

    private class ControlPanel extends JPanel {

        final JTextField sequenceField = new JTextField(10);
        final JTextField deltaField = new JTextField(3);

        ControlPanel() {
            this.sequenceField.setHorizontalAlignment(JTextField.RIGHT);
            this.deltaField.setHorizontalAlignment(JTextField.RIGHT);
            this.sequenceField.setEditable(false);
            this.deltaField.setEditable(false);
            this.setLayout(new FlowLayout());
            this.add(this.sequenceField);
            this.add(this.deltaField);
        }
    }

    private final PaintPanel paintPanel = new PaintPanel();
    private final ControlPanel controlPanel = new ControlPanel();

    private final Color color;

    DiagramPanel(Color color) {
        this.color = color;
        this.setLayout(new BorderLayout());
        this.add(this.paintPanel, BorderLayout.CENTER);
        this.add(this.controlPanel, BorderLayout.SOUTH);
    }

    void processMessage(Message message) {
        this.paintPanel.processMessage(message);
    }
}

