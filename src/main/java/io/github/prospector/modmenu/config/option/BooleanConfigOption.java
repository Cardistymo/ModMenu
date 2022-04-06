package io.github.prospector.modmenu.config.option;

import io.github.prospector.modmenu.util.ScreenTexts;
import io.github.prospector.modmenu.util.TranslationUtil;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class BooleanConfigOption {
	private final String key, translationKey;
	private final boolean defaultValue;
	private final Text enabledText;
	private final Text disabledText;

	public BooleanConfigOption(String key, boolean defaultValue, String enabledKey, String disabledKey) {
		ConfigOptionStorage.setBoolean(key, defaultValue);
		this.key = key;
		this.translationKey = TranslationUtil.translationKeyOf("option", key);
		this.defaultValue = defaultValue;
		this.enabledText = new TranslatableText(translationKey + "." + enabledKey);
		this.disabledText = new TranslatableText(translationKey + "." + disabledKey);
	}

	public BooleanConfigOption(String key, boolean defaultValue) {
		this(key, defaultValue, "true", "false");
	}

	public String getKey() {
		return key;
	}

	public boolean getValue() {
		return ConfigOptionStorage.getBoolean(key);
	}

	public void setValue(boolean value) {
		ConfigOptionStorage.setBoolean(key, value);
	}

	public void toggleValue() {
		ConfigOptionStorage.toggleBoolean(key);
	}

	public boolean getDefaultValue() {
		return defaultValue;
	}

	public Text getButtonText() {
		return ScreenTexts.composeGenericOptionText(new TranslatableText(translationKey), getValue() ? enabledText : disabledText);
	}

//	@Override
//	public CyclingOption<Boolean> asOption() {
//		if (enabledText != null && disabledText != null) {
//			return CyclingOption.create(translationKey, enabledText, disabledText, ignored -> ConfigOptionStorage.getBoolean(key), (ignored, option, value) -> ConfigOptionStorage.setBoolean(key, value));
//		}
//		return CyclingOption.create(translationKey, ignored -> ConfigOptionStorage.getBoolean(key), (ignored, option, value) -> ConfigOptionStorage.setBoolean(key, value));
//	}
}
