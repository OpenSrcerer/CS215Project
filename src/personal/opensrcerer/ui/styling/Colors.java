package personal.opensrcerer.ui.styling;

import java.awt.*;

/**
 * An enum that shows the available colors
 * for the UI. Inspired by the Discord theme.
 */
public enum Colors {
    discordLightGray(new Color(185, 187, 190)),
    discordLessGray(new Color(71, 71, 71)),
    discordGray(new Color(54, 57, 63)),
    discordGrayer(new Color(47, 49, 54));

    private final Color color;

    Colors(Color color) {
        this.color = color;
    }

    public Color get() {
        return this.color;
    }
}