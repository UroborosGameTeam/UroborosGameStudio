package uroborosGameStudio.domain;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.component.Scene;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class ActorWrapper extends GameObject  implements Serializable 
{
	
	private static final long serialVersionUID = 1L;
	public String path;
	public Point point;
	public Dimension dimension;
	transient BufferedImage image;
	public double frames;

	public ActorWrapper(String name, String path, Integer x, Integer y, Integer width, Integer height) {
		this.name = name;
		this.ext = ".act";
		this.path = path;
		readImage(path);
		this.point = new Point(x, y);
		this.dimension = new Dimension(width, height);
		this.frames = 1;
	}
	
	public Point getPoint()
	{
		return this.point;
	}

	public double getRealWidth() {
		return this.image.getWidth();
	}

	public double getRealHeight() {
		return this.image.getHeight();
	}

	private void readImage(String path) {
		try {
			this.image = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BufferedImage getImage() {
		return this.image;
	}

	@Override
	public Integer getX() {
		return this.point.x;
	}

	@Override
	public Integer getY() {
		return this.point.y;
	}

	@Override
	public Integer getWidth() {
		return this.dimension.width;
	}

	@Override
	public Integer getHeight() {
		return this.dimension.height;
	}

	@Override
	public void setName(String newName) {
		Game.rename(Game.getActor(name), newName);
		this.name = newName;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public void setSceneUEngine() 
	{
		Scene selectedScene = Game.getSceneWithActor(this.name);
		Game.setScene(selectedScene);
	}

	@Override
	public SceneWrapper selectedScene(MainWindowModel model) 
	{
		return model.searchScene(Game.getSceneWithActor(this.getName()).getName());
	}

	@Override
	public void setPosition(int x, int y) 
	{
		this.point = new Point(x,y);	
	}

	public Boolean hasName(String name) 
	{
		return getName().equals(name);
	}

	@Override
	public String getPathImage() {
		return this.path;
	}

	@Override
	public void setPathImage(String path) 
	{
		this.path = path;
		readImage(path);
		// CAMBIAR EL PATH EN U-ENGINE
	}

	@Override
	public void setDimensionImage(Integer width, Integer height) 
	{
		this.dimension = new Dimension(width, height);
		Game.getActor(name).setDimension(width, height);
	}
	
}
