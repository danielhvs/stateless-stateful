package br.com.danielhabib.snake;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

public abstract class AMovingRules {
	protected Snake snake;
	protected final Point movingOffset;

	public AMovingRules(Snake snake) {
		this(snake, new Point(1, 0));
	}

	public AMovingRules(Snake snake, Point offset) {
		this.snake = snake;
		this.movingOffset = offset;
	}

	public abstract AMovingRules move();

	protected abstract AMovingRules newInstanceOfMovingRules(Snake snake, Point point);

	public AMovingRules turnLeft() {
		Map<Point, Point> leftTurningOffsetMap = new HashMap<Point, Point>();
		leftTurningOffsetMap = new HashMap<Point, Point>();
		leftTurningOffsetMap.put(new Point(1, 0), new Point(0, -1));
		leftTurningOffsetMap.put(new Point(0, -1), new Point(-1, 0));
		leftTurningOffsetMap.put(new Point(-1, 0), new Point(0, 1));
		leftTurningOffsetMap.put(new Point(0, 1), new Point(1, 0));

		return newInstanceOfMovingRules(snake, leftTurningOffsetMap.get(movingOffset));
	}

	public AMovingRules turnRight() {
		Map<Point, Point> rightTurningOffsetMap = new HashMap<Point, Point>();
		rightTurningOffsetMap = new HashMap<Point, Point>();
		rightTurningOffsetMap.put(new Point(1, 0), new Point(0, 1));
		rightTurningOffsetMap.put(new Point(0, 1), new Point(-1, 0));
		rightTurningOffsetMap.put(new Point(-1, 0), new Point(0, -1));
		rightTurningOffsetMap.put(new Point(0, -1), new Point(1, 0));

		return newInstanceOfMovingRules(snake, rightTurningOffsetMap.get(movingOffset));
	}

	public void draw(Graphics g) {
		Point position = snake.getPosition();

		int x = position.getX();
		int y = position.getY();
		int nextX = x + movingOffset.getX();
		int nextY = y + movingOffset.getY();
		g.drawRect(nextX * 16, nextY * 16, 16, 16);

		movingOffset.draw();
		snake.draw();
	}

	public Snake getSnake() {
		return snake;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movingOffset == null) ? 0 : movingOffset.hashCode());
		result = prime * result + ((snake == null) ? 0 : snake.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AMovingRules other = (AMovingRules) obj;
		if (movingOffset == null) {
			if (other.movingOffset != null)
				return false;
		} else if (!movingOffset.equals(other.movingOffset))
			return false;
		if (snake == null) {
			if (other.snake != null)
				return false;
		} else if (!snake.equals(other.snake))
			return false;
		return true;
	}

}