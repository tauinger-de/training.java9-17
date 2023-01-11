package jj.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JFrame;

import jj.core.Message;

public class DiagramFrame extends JFrame {

	private final DiagramPanel[] panels;
	
	private AtomicBoolean isClosed = new AtomicBoolean(false);
	
	public DiagramFrame(String title, int x, int y, Color color, int panelCount) {
		super(title);
		this.setLayout(new GridLayout(1, panelCount));
		this.panels = new DiagramPanel[panelCount];
		for(int i = 0; i < panelCount; i++) 
			this.add(this.panels[i] = new DiagramPanel(color));

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				DiagramFrame.this.dispose();
			}
			public void windowClosed(WindowEvent e) {
				DiagramFrame.this.isClosed.set(true);
			}
		});
		this.pack();
		this.setLocation(x, y);
		this.setVisible(true);
	}

	public boolean isClosed() {
		return this.isClosed.get();
	}
	
	public void processMessage(int index, Message message) {
		this.panels[index].processMessage(message);
	}
}
