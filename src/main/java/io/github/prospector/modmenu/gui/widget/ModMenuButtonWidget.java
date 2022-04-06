package io.github.prospector.modmenu.gui.widget;

import io.github.prospector.modmenu.gui.ModListScreen;
import io.github.prospector.modmenu.gui.widget.AbstractButtonWidget;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class ModMenuButtonWidget extends AbstractButtonWidget {
	public ModMenuButtonWidget( int id, int x, int y, int width, int height, Text text, Screen parent ) {
		super( id, x, y, width, height, text, button -> MinecraftClient.getInstance().openScreen( new ModListScreen( parent ) ) );
	}
}
