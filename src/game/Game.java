package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

/**
 * This class has the View and Model elements in the Game constructor and the
 * Controller elements in the actionPerformed() method, it uses JComponents to
 * build a battleship game.
 * 
 * @author Tahmid Khan Arnab
 *
 */
public class Game extends JFrame implements ActionListener {
	/**
	 * Identifier
	 */
	private static final long serialVersionUID = 2;
	/**
	 * Border for options buttons
	 */
	private Border button = BorderFactory.createLineBorder(Color.GREEN, 2);
	/**
	 * Empty border
	 */
	private Border empty = BorderFactory.createEmptyBorder();
	/**
	 * To generate random numbers for enemy attacks
	 */
	private Random r = new Random();
	/**
	 * Main title icon
	 */
	private ImageIcon mainTitle = getMainTitle();
	/**
	 * Main logo icon
	 */
	private ImageIcon mainLogo = getMainLogo();
	/**
	 * Main icon
	 */
	private Image mainIcon = getMainIcon();
	/**
	 * Default font
	 */
	private Font font = new Font("Consolas", Font.PLAIN, 15);
	/**
	 * JFrame that has the game
	 */
	private JFrame frame;
	/**
	 * JFrame that has main menu
	 */
	private JFrame mainMenu;
	/**
	 * A splash screen
	 */
	private JFrame splash;
	/**
	 * Middle panel in main JFrame
	 */
	private JPanel panel;
	/**
	 * JPanel that holds player's buttons (ships)
	 */
	private JPanel playerBoard;
	/**
	 * JPanel that holds player HP and their board
	 */
	private JPanel playerBoardHolder;
	/**
	 * JPanel that holds enemy's buttons (ships)
	 */
	private JPanel enemyBoard;
	/**
	 * JPanel that holds enemy HP and their board
	 */
	private JPanel enemyBoardHolder;
	/**
	 * Label that shows on splash screen
	 */
	private JLabel splashLabel;
	/**
	 * Label that gives credit to me
	 */
	private JLabel creditLabel;
	/**
	 * Button that shows the solution
	 */
	private JButton solutionButton;
	/**
	 * Button to change colours
	 */
	private JButton colorsButton;
	/**
	 * Button to start playing a game
	 */
	private JButton playButton;
	/**
	 * Button that holds the main title icon in main menu
	 */
	private JButton titleButton;
	/**
	 * Button that holds the main logo icon in main menu
	 */
	private JButton logoButton;
	/**
	 * Button that holds main logo during the game
	 */
	private JButton logoGame;
	/**
	 * Button that holds main title icon during the game
	 */
	private JButton titleGame;
	/**
	 * String that represents the player's config
	 */
	private String shipString;
	/**
	 * String that represents the enemy's config
	 */
	private String shipString2;
	/**
	 * Row 1 array to be used to generate enemy config
	 */
	private String[] row1Array = { "22000", "02200", "00220", "00022" };
	/**
	 * Row 2 array to be used to generate enemy config
	 */
	private String[] row2Array = { "10200", "00210", "01200", "00201" };
	/**
	 * Row 3 array to be used to generate enemy config
	 */
	private String[] row3Array = { "30201", "30210", "31200" };
	/**
	 * Row 4 array to be used to generate enemy config
	 */
	private String[] row4Array = { "30000" };
	/**
	 * Row 5 array to be used to generate enemy config
	 */
	private String[] row5Array = { "31000", "30100", "30010", "30001" };
	/**
	 * Row 1 string
	 */
	private String row1 = row1Array[r.nextInt(4)];
	/**
	 * Row 2 string
	 */
	private String row2 = row2Array[r.nextInt(4)];
	/**
	 * Row 3 string
	 */
	private String row3 = row3Array[r.nextInt(3)];
	/**
	 * Row 4 string
	 */
	private String row4 = row4Array[r.nextInt(1)];
	/**
	 * Row 5 string
	 */
	private String row5 = row5Array[r.nextInt(4)];
	/**
	 * Represents player's health
	 */
	private JProgressBar playerHealth = new JProgressBar(0, 20);
	/**
	 * Represents enemy's health
	 */
	private JProgressBar enemyHealth = new JProgressBar(0, 20);
	/**
	 * Indeterminate loading bar for splash screen
	 */
	private JProgressBar load = new JProgressBar();
	/**
	 * Array representing enemy buttons (ships)
	 */
	private ShipButton[] enemyShips = new ShipButton[25];
	/**
	 * Array representing player buttons (ships)
	 */
	private ShipButton[] playerShips = new ShipButton[25];
	/**
	 * Background colour
	 */
	private Color bg = Color.BLACK;
	/**
	 * Good/safe colour
	 */
	private Color good = Color.GREEN;
	/**
	 * Enemy/bad colour
	 */
	private Color bad = Color.RED;
	/**
	 * RandomGuesser to check random ships in the player's board
	 */
	private RandomGuesser guesser = new RandomGuesser(0, 24);
	/**
	 * Enemy's points, used to represent health
	 */
	private int enemyPoints = 0;
	/**
	 * Player's points, used to represent health
	 */
	private int playerPoints = 0;
	/**
	 * Whether or not the user won
	 */
	private boolean isWon = false;
	/**
	 * Text prompting user to select good colour
	 */
	private String goodColor;
	/**
	 * Text prompting user to select bad colour
	 */
	private String badColor;
	/**
	 * Label for theme button
	 */
	private String theme;
	/**
	 * Text prompting user to enter ship config
	 */
	private String designText;
	/**
	 * Text showing if inappropriate ship config is used
	 */
	private String shipError;
	/**
	 * Text shown if user wins
	 */
	private String victoryText;
	/**
	 * Text shown if user loses
	 */
	private String defeatText;
	/**
	 * Title of dialog shown if user wins
	 */
	private String victory;
	/**
	 * Title of dialog shown if user loses
	 */
	private String defeat;
	/**
	 * Label for solution button
	 */
	private String solutionText;
	/**
	 * Dimension for health bar
	 */
	private Dimension healthSize = new Dimension(650, 30);
	/**
	 * Dimension for board holders of players (board + health bar)
	 */
	private Dimension boardHolderSize = new Dimension(700, 1000);
	/**
	 * Dimension for logo icon
	 */
	private Dimension logoSize = new Dimension(80, 80);
	/**
	 * Dimension for player boards
	 */
	private Dimension boardSize = new Dimension(650, 650);
	/**
	 * Dimension for game window
	 */
	private Dimension gameSize = new Dimension(1500, 800);
	/**
	 * Dimension for menu window
	 */
	private Dimension menuSize = new Dimension(400, 300);

	/**
	 * Default constructor which starts the game, it sets up the View and the Model
	 * elements
	 */
	public Game() {
		UIManager.put("Button.select", Color.DARK_GRAY);
		UIManager.put("Button.disabledText", good);

		splashLabel = new JLabel("", mainTitle, SwingConstants.CENTER);
		splashLabel.setBackground(bg);

		load.setIndeterminate(true);
		load.setBackground(bg);
		load.setForeground(good);
		load.setBorder(empty);

		splash = new JFrame();
		splash.add(splashLabel, BorderLayout.CENTER);
		splash.add(load, BorderLayout.SOUTH);
		splash.setUndecorated(true);
		splash.getContentPane().setBackground(Color.BLACK);
		splash.setIconImage(mainIcon);
		splash.pack();
		splash.setLocationRelativeTo(null);
		splash.setVisible(true);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		splash.dispose();

		titleButton = new JButton(mainTitle);
		titleButton.setBackground(bg);
		titleButton.setBorder(empty);
		titleButton.setContentAreaFilled(false);
		titleButton.setPreferredSize(logoSize);
		titleButton.setFocusable(false);

		logoButton = new JButton(mainLogo);
		logoButton.setBackground(bg);
		logoButton.setBorder(empty);
		logoButton.setContentAreaFilled(false);
		logoButton.setPreferredSize(logoSize);
		logoButton.setFocusable(false);

		playButton = new JButton();
		playButton.setFont(font);
		playButton.setText("Play");
		playButton.setBackground(bg);
		playButton.setForeground(good);
		playButton.setFocusable(false);
		playButton.setBorder(button);
		playButton.setText("Play");
		playButton.setVisible(true);
		playButton.addActionListener(this);

		mainMenu = new JFrame();
		mainMenu.setLayout(new GridLayout(3, 1));
		mainMenu.setBounds(400, 300, 200, 100);
		mainMenu.setPreferredSize(menuSize);
		mainMenu.setTitle("Break Down");
		mainMenu.setVisible(true);
		mainMenu.getContentPane().setBackground(bg);
		mainMenu.setIconImage(mainIcon);
		mainMenu.add(logoButton);
		mainMenu.add(titleButton);
		mainMenu.add(playButton);
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenu.pack();
		mainMenu.setLocationRelativeTo(null);

		logoGame = new JButton(mainTitle);
		logoGame.setContentAreaFilled(false);
		logoGame.setVisible(false);
		logoGame.setBorder(empty);
		logoGame.setAlignmentX(Component.CENTER_ALIGNMENT);

		titleGame = new JButton(mainLogo);
		titleGame.setContentAreaFilled(false);
		titleGame.setBorder(empty);
		titleGame.setVisible(false);
		titleGame.setAlignmentX(Component.CENTER_ALIGNMENT);

		playerBoard = new JPanel();
		playerBoard.setPreferredSize(boardSize);
		playerBoard.setLayout(new GridLayout(5, 5));
		playerBoard.setBackground(bg);

		playerHealth.setValue(20);
		playerHealth.setStringPainted(false);
		playerHealth.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, good, bg));
		playerHealth.setPreferredSize(healthSize);
		playerHealth.setString(null);
		playerHealth.setForeground(good);
		playerHealth.setBackground(bg);
		playerHealth.setVisible(false);

		enemyBoard = new JPanel();
		enemyBoard.setPreferredSize(boardSize);
		enemyBoard.setLayout(new GridLayout(5, 5));
		enemyBoard.setBackground(bg);

		enemyHealth.setValue(20);
		enemyHealth.setStringPainted(false);
		enemyHealth.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, good, bg));
		enemyHealth.setPreferredSize(healthSize);
		enemyHealth.setString(null);
		enemyHealth.setForeground(bad);
		enemyHealth.setBackground(bg);
		enemyHealth.setVisible(false);

		playerBoardHolder = new JPanel();
		playerBoardHolder.setPreferredSize(boardHolderSize);
		playerBoardHolder.setBackground(bg);
		playerBoardHolder.add(playerBoard, BorderLayout.CENTER);
		playerBoardHolder.add(playerHealth, BorderLayout.SOUTH);
		playerBoardHolder.setBorder(new EmptyBorder(20, 20, 0, 20));

		enemyBoardHolder = new JPanel();
		enemyBoardHolder.setPreferredSize(boardHolderSize);
		enemyBoardHolder.setBackground(bg);
		enemyBoardHolder.add(enemyBoard, BorderLayout.CENTER);
		enemyBoardHolder.add(enemyHealth, BorderLayout.SOUTH);
		enemyBoardHolder.setBorder(new EmptyBorder(20, 20, 0, 20));

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(bg);
		panel.setBorder(new EmptyBorder(40, 0, 0, 0));
		panel.add(logoGame);
		panel.add(titleGame);

		creditLabel = new JLabel("© 2024 Tahmid Khan Arnab - All Rights Reserved", SwingConstants.CENTER);
		creditLabel.setFont(new Font("Serif", Font.BOLD, 14));
		creditLabel.setPreferredSize(new Dimension(20, 50));
		creditLabel.setForeground(Color.WHITE);
		creditLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

		frame = new JFrame();
		frame.setVisible(false);
		frame.setIconImage(mainIcon);
		frame.setResizable(false);
		frame.setTitle("Break Down");
		frame.setPreferredSize(gameSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(bg);
		frame.add(playerBoardHolder, BorderLayout.WEST);
		frame.add(enemyBoardHolder, BorderLayout.EAST);
		frame.add(panel);
		frame.add(creditLabel, BorderLayout.SOUTH);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Main method, creates a Game() object
	 * 
	 * @param args Main method arguments
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Game game = new Game();
	}

	/**
	 * Overridden actionPerformed method, this is the main Controller method and
	 * also has some Model elements
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == playButton) {
			setStrings();
			mainMenu.setVisible(false);
			shipString = JOptionPane.showInputDialog(designText, "03010.03220.03020.01020.00100");
			frame.setVisible(true);
			int shipCount = 0;
			int playerShipCount = 0;
			logoGame.setVisible(true);
			titleGame.setVisible(true);
			colorsButton = new JButton(theme);
			colorsButton.setFont(font);
			colorsButton.setBackground(bg);
			colorsButton.setForeground(good);
			colorsButton.setFocusable(false);
			colorsButton.setBorder(button);
			colorsButton.addActionListener(this);
			colorsButton.setVisible(true);
			colorsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(Box.createVerticalStrut(10));
			panel.add(colorsButton);
			solutionButton = new JButton(solutionText);
			solutionButton.setFont(font);
			solutionButton.setBackground(bg);
			solutionButton.setForeground(good);
			solutionButton.setFocusable(false);
			solutionButton.setBorder(button);
			solutionButton.addActionListener(this);
			solutionButton.setVisible(true);
			solutionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(Box.createVerticalStrut(10));
			panel.add(solutionButton);
			playerHealth.setVisible(true);
			enemyHealth.setVisible(true);
			String[] rowStrings = shipString.split("\\.");
			int[][] shipArray = new int[rowStrings.length][rowStrings.length];
			for (int i = 0; i < 5; i++) {
				String rowString = rowStrings[i];

				for (int j = 0; j < 5; j++) {
					char digitChar = rowString.charAt(j);
					int digit = Character.getNumericValue(digitChar);
					shipArray[i][j] = digit;
				}
			}
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					ShipButton button = new ShipButton(String.valueOf(shipArray[i][j]), true, good, bad, bg);
					playerShips[playerShipCount] = button;
					playerShipCount++;
					playerBoard.add(button);
				}
			}
			int sum = 0;
			for (int[] row : shipArray) {
				for (int element : row) {
					sum += element;
				}
			}
			if (sum != 20) {
				JOptionPane.showMessageDialog(frame, shipError, "Error", JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
			shipString2 = row1 + "." + row2 + "." + row3 + "." + row4 + "." + row5;
			String[] rowStrings2 = shipString2.split("\\.");
			int[][] shipArray2 = new int[rowStrings.length][rowStrings.length];
			for (int i = 0; i < 5; i++) {
				String rowString = rowStrings2[i];

				for (int j = 0; j < 5; j++) {
					char digitChar = rowString.charAt(j);
					int digit = Character.getNumericValue(digitChar);
					shipArray2[i][j] = digit;
				}
			}
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					ShipButton button = new ShipButton(String.valueOf(shipArray2[i][j]), false, good, bad, bg);
					button.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							playerPoints += button.getValue();
							enemyHealth.setValue(20 - playerPoints);
							if (playerPoints == 20) {
								button.setBackground(bad);
								enemyHealth.setValue(20 - playerPoints);
								isWon = true;
								JOptionPane.showMessageDialog(frame, victoryText, victory, JOptionPane.WARNING_MESSAGE);
								System.exit(0);
							}
							ShipButton ship = playerShips[guesser.makeGuess()];
							ship.showSolution();
							playerHealth.setValue(20 - enemyPoints);
							enemyPoints += ship.getValue();

							if (enemyPoints == 20 && !isWon) {
								playerHealth.setValue(20 - enemyPoints);
								JOptionPane.showMessageDialog(frame, defeatText, defeat, JOptionPane.WARNING_MESSAGE);
								System.exit(0);
							}
						}
					});
					enemyShips[shipCount] = button;
					shipCount++;
					enemyBoard.add(button);
				}
			}
		} else if (e.getSource() == colorsButton) {
			good = JColorChooser.showDialog(Game.this, goodColor, Color.GREEN);
			bad = JColorChooser.showDialog(Game.this, badColor, Color.RED);
			playerHealth.setForeground(good);
			enemyHealth.setForeground(bad);
			UIManager.put("Button.disabledText", good);
			for (int i = 0; i < 25; i++) {
				enemyShips[i].setColors(good, bad);
				playerShips[i].setColors(good, bad);
			}
		} else if (e.getSource() == solutionButton) {
			for (int j = 0; j < 25; j++) {
				enemyShips[j].showSolution();
			}
			enemyBoard.repaint();
			enemyHealth.setValue(0);
		}
	}

	/**
	 * Sets the language for the game
	 */
	public void setStrings() {
		goodColor = "Choose safe color";
		badColor = "Choose enemy color";
		theme = " Colors ";
		designText = "Design your ships (every 5 digits is a row)";
		shipError = "Inappropriate ship configuration!";
		victoryText = "You won the game! Congratulations! :)";
		defeatText = "You lost the game! Better luck next time :(";
		victory = "Victory";
		defeat = "Defeat";
		solutionText = " Solve ";
	}

	/**
	 * 
	 * @return the main icon
	 */
	private Image getMainIcon() {
		ImageIcon i = new ImageIcon("images/logo2.png");
		Image j = i.getImage();
		return j;
	}

	/**
	 * 
	 * @return the main title as a resized ImageIcon
	 */
	private ImageIcon getMainTitle() {
		ImageIcon i = new ImageIcon("images/logo.png");
		Image j = i.getImage();
		ImageIcon k = new ImageIcon(j.getScaledInstance(100, 60, java.awt.Image.SCALE_SMOOTH));
		return k;
	}

	/**
	 * 
	 * @return the main logo as a resized ImageIcon
	 */
	private ImageIcon getMainLogo() {
		ImageIcon i = new ImageIcon("images/logo2.png");
		Image j = i.getImage();
		ImageIcon k = new ImageIcon(j.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		return k;
	}
}