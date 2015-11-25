package br.com.danielhabib.snake;

public enum Direction {
	UP(new Point(0, -1)), DOWN(new Point(0, 1)), LEFT(new Point(-1, 0)), RIGHT(new Point(1, 0));
	private Point direction;

	private Direction(Point direction) {
		this.direction = direction;
	}

	public Point getDirection() {
		return direction;
	}
}
