/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui;

import personal.opensrcerer.ui.components.custom.Banner;
import personal.opensrcerer.ui.components.custom.NodeViewPort;
import personal.opensrcerer.ui.components.events.ButtonType;
import personal.opensrcerer.ui.components.events.FieldType;
import personal.opensrcerer.ui.components.regular.*;
import personal.opensrcerer.ui.styling.DiscordColor;
import personal.opensrcerer.ui.styling.Fonts;

import javax.swing.*;
import java.awt.*;

/**
 * A class that manages static instances of the main Window layout.
 */
public abstract class WindowLayout {

    /**
     * The top banner to display messages.
     */
    public static final Banner banner = new Banner();

    /**
     * The KTextField where users input the suicide number.
     */
    public static final KTextField suiciderNumberField = new KTextField("", 5, FieldType.SUICIDERS);

    /**
     * The KTextField where users input the magic number.
     */
    public static final KTextField magicNumberField = new KTextField("", 5, FieldType.MAGIC_NUMBER);

    /**
     * An array of the four pagination buttons.
     */
    public static final KButton[] buttons = {
            new KButton("Previous", ButtonType.PREVIOUS),
            new KButton("First", ButtonType.FIRST),
            new KButton("Next", ButtonType.NEXT),
            new KButton("Last", ButtonType.LAST),
    };

    /**
     * The NodeViewPort instance.
     */
    public static final NodeViewPort viewportPane = new NodeViewPort();

    /**
     * Set all elements for the main window pane.
     */
    public static void set() {
        final JPanel mainPanel =    new KPanel(BoxLayout.PAGE_AXIS),
                viewportWrapper =   new KPanel(),
                textFieldWrapper =  new KPanel(BoxLayout.LINE_AXIS, DiscordColor.darkPurple),
                leftFieldWrapper =  new KPanel(BoxLayout.PAGE_AXIS, DiscordColor.darkPurple),
                rightFieldWrapper = new KPanel(BoxLayout.PAGE_AXIS, DiscordColor.darkPurple),
                inputWrapper =      new KPanel(new FlowLayout(), DiscordColor.darkPurple),
                borderWrapper =     new KPanel(new BorderLayout(), DiscordColor.darkPurple),
                reverseWrapper =    new KPanel(new GridLayout(2, 1), DiscordColor.darkPurple),
                forwardWrapper =    new KPanel(new GridLayout(2, 1), DiscordColor.darkPurple);

        viewportWrapper.add(viewportPane);

        leftFieldWrapper.add(new KLabel("Number of Suiciders", Fonts.titleFont));
        leftFieldWrapper.add(boxRigidArea(0, 5));
        leftFieldWrapper.add(suiciderNumberField);

        rightFieldWrapper.add(new KLabel("Magic Number", Fonts.titleFont));
        rightFieldWrapper.add(boxRigidArea(0, 5));
        rightFieldWrapper.add(magicNumberField);

        textFieldWrapper.add(leftFieldWrapper);
        textFieldWrapper.add(boxRigidArea(50, 0));
        textFieldWrapper.add(rightFieldWrapper);

        inputWrapper.add(textFieldWrapper);

        forwardWrapper.add(buttons[0]);
        forwardWrapper.add(buttons[1]);
        reverseWrapper.add(buttons[2]);
        reverseWrapper.add(buttons[3]);

        borderWrapper.add(forwardWrapper, BorderLayout.WEST);
        borderWrapper.add(inputWrapper, BorderLayout.CENTER);
        borderWrapper.add(reverseWrapper, BorderLayout.EAST);

        mainPanel.add(banner);
        mainPanel.add(new KSeparator());
        mainPanel.add(boxRigidArea(0, 25));
        mainPanel.add(viewportPane);
        mainPanel.add(new KSeparator());
        mainPanel.add(borderWrapper);

        Window.contentPane().add(mainPanel);
    }

    /**
     * Utility method that creates a rigid area with x and y values.
     * Used as syntactic sugar.
     * @param x X value of the rigid area.
     * @param y Y value of the rigid area.
     * @return Newly created rigid area with the size X, Y.
     */
    public static Component boxRigidArea(int x, int y) {
        return Box.createRigidArea(new Dimension(x, y));
    }
}
