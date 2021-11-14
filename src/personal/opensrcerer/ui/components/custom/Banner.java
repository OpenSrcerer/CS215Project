package personal.opensrcerer.ui.components.custom;

import personal.opensrcerer.ui.components.stylized.KLabel;
import personal.opensrcerer.ui.components.stylized.KPanel;
import personal.opensrcerer.ui.styling.Fonts;

import java.awt.*;

/**
 * The top banner that contains the announcement text.
 */
public class Banner extends KPanel {

    /**
     * The label that contains this banner's text.
     */
    private final KLabel bannerText;

    /**
     * Create a new preset banner.
     */
    public Banner() {
        super();
        this.setPreferredSize(new Dimension(500, 45));
        bannerText = new KLabel("lol", Fonts.bigTitleFont);
        add(bannerText, BorderLayout.CENTER);
    }

    /**
     * Updates the banner's message to the given text.
     * @param text Text to update banner to.
     */
    public void update(String text) {
        // Show the round message if the current player is not a bot.
        bannerText.setText(text);
        revalidate();
        repaint();
    }
}