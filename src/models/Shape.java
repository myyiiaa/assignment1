package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Shape {

    private List<Point> points;

    public Shape() {
        this.points = points;
    }

    public double calculatePerimeter() {
        double perimeter = 0.0;
        int numPoints = points.size();

        for (int i = 0; i < numPoints; i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % numPoints); // Connect last point to the first one

            perimeter += currentPoint.distanceTo(nextPoint);
        }

        return perimeter;
    }

    public double findLongestSide() {
        double longestSide = 0.0;

        for (int i = 0; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % points.size());

            double distance = currentPoint.distanceTo(nextPoint);
            if (distance > longestSide) {
                longestSide = distance;
            }
        }

        return longestSide;
    }

    public double calculateAverageSide() {
        double sum = 0.0;

        for (int i = 0; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % points.size());

            sum += currentPoint.distanceTo(nextPoint);
        }

        return sum / points.size();
    }

    private static List<Point> readCoordinatesFromFile(String fileName) {
        List<Point> points = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] coordinates = line.split(",");
                double x = Double.parseDouble(coordinates[0]);
                double y = Double.parseDouble(coordinates[1]);
                points.add(new Point(x, y));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return points;
    }

    public void addPoint(Point point) {
        points.add(point);
    }
}