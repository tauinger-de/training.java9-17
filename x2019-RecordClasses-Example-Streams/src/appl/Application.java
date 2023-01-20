package appl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("preview")
public class Application {
    public static void main(String[] args) {
        final List<Point> points = List.of(new Point(10, 20), new Point(1, 2), new Point(5, 5));
        final List<Point> sortedPoints = sort(points);
        sortedPoints.forEach(System.out::println);
    }

    static List<Point> sort(List<Point> points) {
        record PointWithSize(Point point, double size) {
            public PointWithSize(Point p) {
                this(p, Math.sqrt(p.x() * p.x() + p.y() * p.y()));
            }
        }
        return points
                .stream()
                .map(p -> new PointWithSize(p))
                .sorted(Comparator.comparingDouble(pws -> pws.size()))
                .map(pws -> pws.point)
                .collect(Collectors.toList());
    }

    static List<Point> sort2(List<Point> points) {
        record PointWithSize(Point point, double size) {
            public PointWithSize(Point p) {
                this(p, Math.sqrt(p.x() * p.x() + p.y() * p.y()));
            }
        }
        return points
                .stream()
                .map(PointWithSize::new)
                .sorted(Comparator.comparingDouble(PointWithSize::size))
                .map(PointWithSize::point)
                .collect(Collectors.toList());
    }
}
