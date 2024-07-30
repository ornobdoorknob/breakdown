package game;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * This class has elements from the Model, View and the Controller. This class
 * extends JButton to simulate the behaviour of a part of a ship.
 * 
 * @author Tahmid Khan Arnab
 *
 */
public class ShipButton extends JButton implements ActionListener {
	/**
	 * Identifier
	 */
	private static final long serialVersionUID = 1;
	/**
	 * Value of button
	 */
	private int value;
	/**
	 * Good/safe colour
	 */
	private Color good = Color.GREEN;
	/**
	 * Enemy/bad colour
	 */
	private Color bad = Color.RED;
	/**
	 * Whether or not the ship is nuked (button is clicked)
	 */
	private boolean isNuked = false;

	/**
	 * Font for the ship's number
	 */
	private Font font = new Font("Consolas", Font.PLAIN, 30);

	/**
	 * Main constructor used to create a ShipButton
	 * 
	 * @param label     the value and the label for the player
	 * @param isVisible whether or not the label is visible
	 * @param good      good/safe colour
	 * @param bad       enemy/bad colour
	 * @param bg        background colour
	 */
	public ShipButton(String label, boolean isVisible, Color good, Color bad, Color bg) {
		super(label);
		value = Integer.parseInt(label);
		this.setPreferredSize(new Dimension(50, 50));
		this.good = good;
		this.bad = bad;
		setFocusable(false);
		setFont(font);
		setBackground(bg);
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GREEN, Color.DARK_GRAY));
		addActionListener(this);
		if (isVisible && value > 0) {
			setText(value + "");
			setForeground(good);
			setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.GREEN, Color.GREEN));
		} else if (isVisible) {
			setText("");
		} else {
			setForeground(bg);
		}
		if (isVisible) {
			setEnabled(false);
		}
	}

	/**
	 * Show the button's label and change it to the appropriate colour
	 */
	public void showSolution() {
		setText(value + "");
		setEnabled(false);
		checkShip();
	}

	@Override
	/**
	 * Overridden actionPerformed method, checks the ship and makes the button
	 * disabled so the user does not make the same move again
	 */
	public void actionPerformed(ActionEvent e) {
		setEnabled(false);
		checkShip();
	}

	/**
	 * Sets the appropriate good/bad colour of button and label according to value,
	 * and sets isNuked to true
	 */
	public void checkShip() {
		isNuked = true;
		if (value == 0) {
			setBackground(good);
		} else {
			setText(value + "");
			setBackground(bad);
		}
		repaint();
	}

	/**
	 * Getter for value, used to calculate points/HP
	 * 
	 * @return Number inside ShipButton
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Setter for colours, if the ship is nuked, sets colour accordingly, then
	 * repaints
	 * 
	 * @param good safe/good colour
	 * @param bad  enemy/bad colour
	 */
	public void setColors(Color good, Color bad) {
		this.good = good;
		this.bad = bad;
		if (isNuked) {
			checkShip();
		}
		repaint();
	}
}
