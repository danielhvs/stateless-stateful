package br.com.danielhabib.snake;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class SnakeEnd extends Snake {

	@Override
	public Snake addTail(int x, int y) {
		return new Snake(x, y);
	}

	@Override
	public void draw() {
		System.out.println();
	}

	@Override
	public void draw(Graphics g) {
	}

	@Override
	public String toString() {
		return ".";
	}

	@Override
	public Snake move(Point point) {
		return this;
	}

	@Override
	public List<Point> getPositions() {
		return new ArrayList<Point>();
	}

	@Override
	public Snake removeTail() {
		return this;
	}
}
