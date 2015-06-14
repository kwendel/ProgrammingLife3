package tudelft.ti2806.pl3.menubar;

import tudelft.ti2806.pl3.View;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Menubarview is the view for the menubar.
 * Created by Kasper on 27-5-2015.
 */
public class MenuBarView extends JMenuBar implements View {

	List<JMenu> menus;

	/**
	 * Makes the view of the menubar.
	 */
	public MenuBarView() {
		super();
		menus = new ArrayList<>(3);
		add(setUpFile());
		add(setUpView());
		add(setUpHelp());
	}

	/**
	 * Set the Items under the header File.
	 *
	 * @return JMenu file
	 */
	private JMenu setUpFile() {
		JMenu fileMenu = new JMenu("File");
		menus.add(fileMenu);
		fileMenu.setMnemonic(KeyEvent.VK_F);

		JMenuItem openFolder = new JMenuItem("Open folder");
		openFolder.setMnemonic(KeyEvent.VK_O);
		JMenuItem openNode = new JMenuItem("Open node and edge file");
		openNode.setMnemonic(KeyEvent.VK_N);
		JMenuItem openNwk = new JMenuItem("Open .nwk file");
		openNwk.setMnemonic(KeyEvent.VK_W);
		JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_X);

		fileMenu.add(openFolder);
		fileMenu.add(openNode);
		fileMenu.add(openNwk);
		fileMenu.addSeparator();
		fileMenu.add(exit);

		return fileMenu;
	}

	/**
	 * Sets up the item under the header View.
	 *
	 * @return JMenu view
	 */
	private JMenu setUpView() {
		// ascii value of the shortcuts
		final char plus = '+';
		final char minus = '-';
		final char r = 'R';
		final char right = '→';
		final char left = '←';
		final char g = 'G';

		JMenu viewMenu = new JMenu("View");
		menus.add(viewMenu);
		viewMenu.setMnemonic(KeyEvent.VK_V);

		JMenuItem zoomIn = new JMenuItem("Zoom in");
		zoomIn.setAccelerator(KeyStroke.getKeyStroke(plus));
		zoomIn.setMnemonic(KeyEvent.VK_I);
		JMenuItem zoomOut = new JMenuItem("Zoom out");
		zoomOut.setAccelerator(KeyStroke.getKeyStroke(minus));
		zoomOut.setAccelerator(KeyStroke.getKeyStroke(minus));
		zoomOut.setMnemonic(KeyEvent.VK_U);
		JMenuItem moveLeft = new JMenuItem("Move left");
		moveLeft.setAccelerator(KeyStroke.getKeyStroke(left));
		moveLeft.setMnemonic(KeyEvent.VK_L);
		JMenuItem moveRight = new JMenuItem("Move right");
		moveRight.setAccelerator(KeyStroke.getKeyStroke(right));
		moveRight.setMnemonic(KeyEvent.VK_R);
		JMenuItem reset = new JMenuItem("Reset view");
		reset.setAccelerator(KeyStroke.getKeyStroke(r));
		reset.setMnemonic(KeyEvent.VK_S);
		JMenuItem findGenes = new JMenuItem("Navigate to gene");
		findGenes.setAccelerator(KeyStroke.getKeyStroke(g));
		findGenes.setMnemonic(KeyEvent.VK_G);

		viewMenu.add(zoomIn);
		viewMenu.add(zoomOut);
		viewMenu.add(moveLeft);
		viewMenu.add(moveRight);
		viewMenu.add(reset);
		viewMenu.add(findGenes);

		return viewMenu;
	}

	private JMenu setUpHelp() {
		JMenu helpMenu = new JMenu("Help");
		menus.add(helpMenu);
		helpMenu.setMnemonic(KeyEvent.VK_H);

		JMenuItem help = new JMenuItem("Controls");
		help.setMnemonic(KeyEvent.VK_C);
		JMenuItem about = new JMenuItem("About Me");
		about.setMnemonic(KeyEvent.VK_A);

		helpMenu.add(help);
		helpMenu.add(about);

		return helpMenu;
	}

	@Override
	public JMenuBar getPanel() {
		return this;
	}

	/**
	 * Adds an action listener to all menu items.
	 *
	 * @param listener
	 * 		the listener
	 */
	public void addActionListener(ActionListener listener) {
		for (JMenu menu : menus) {
			for (Component component : menu.getMenuComponents()) {
				if (component instanceof JMenuItem) {
					((JMenuItem) component).addActionListener(listener);
				}
			}
		}
	}
}
