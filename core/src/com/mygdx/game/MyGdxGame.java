package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGdxGame extends ApplicationAdapter {
	private Stage stage;
	private Label outputLabel;

	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		int Help_Guides = 12;
		int row_height = Gdx.graphics.getWidth() / 12;
		int col_width = Gdx.graphics.getWidth() / 12;

		Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

		Label title = new Label("Buttons with Skins",mySkin,"big-black");
		title.setSize(Gdx.graphics.getWidth(),row_height*2);
		title.setPosition(0,Gdx.graphics.getHeight()-row_height*2);
		title.setAlignment(Align.center);
		stage.addActor(title);

		// Button
		Button button1 = new Button(mySkin,"small");
		button1.setSize(col_width*4,row_height);
		button1.setPosition(col_width,Gdx.graphics.getHeight()-row_height*3);
		button1.addListener(new InputListener(){
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Press a Button");
			}
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Pressed Button");
				return true;
			}
		});
		stage.addActor(button1);

		// Text Button
		Button button2 = new TextButton("Text Button",mySkin,"small");
		button2.setSize(col_width*4,row_height);
		button2.setPosition(col_width*7,Gdx.graphics.getHeight()-row_height*3);
		button2.addListener(new InputListener(){
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Press a Button");
			}
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Pressed Text Button");
				return true;
			}
		});
		stage.addActor(button2);


		// ImageButton
		ImageButton button3 = new ImageButton(mySkin);
		button3.setSize(col_width*4,(float)(row_height*2));
		button3.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("switch_off.png"))));
		button3.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("switch_on.png"))));
		button3.setPosition(col_width,Gdx.graphics.getHeight()-row_height*6);
		button3.addListener(new InputListener(){
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Press a Button");
			}
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Pressed Image Button");
				return true;
			}
		});
		stage.addActor(button3);

		//ImageTextButton
		ImageTextButton button4 = new ImageTextButton("ImageText Btn",mySkin,"small");
		button4.setSize(col_width*4,(float)(row_height*2));
		button4.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("switch_off.png"))));
		button4.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("switch_on.png"))));
		button4.setPosition(col_width*7,Gdx.graphics.getHeight()-row_height*6);
		button4.addListener(new InputListener(){
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Press a Button");
			}
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Pressed Image Text Button");
				return true;
			}
		});
		stage.addActor(button4);

		outputLabel = new Label("Press a Button",mySkin,"black");
		outputLabel.setSize(Gdx.graphics.getWidth(),row_height);
		outputLabel.setPosition(0,row_height);
		outputLabel.setAlignment(Align.center);
		stage.addActor(outputLabel);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();

	}
}
