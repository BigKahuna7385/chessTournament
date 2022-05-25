package gui;

import game.Game;
import application.Tournament;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import exceptions.InvalidResultException;
import transport.GameToGameGuiMapper;
import transport.GameUiModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameGui extends JFrame {
    private final Tournament tournament;
    private final RoundGui roundGui;
    private final Game game;
    private JTable gameTable;
    private JButton whiteWonButton;
    private JButton blackWonButton;
    private JButton drawButton;
    private JLabel gameLabel;
    private JPanel gamePanel;
    private DefaultTableModel tableModel;

    public GameGui(Tournament tournament, RoundGui roundGui, Game game) {

        this.tournament = tournament;
        this.roundGui = roundGui;
        this.game = game;
        setContentPane(gamePanel);
        setTitle("Round Manager");
        setSize(500, 500);
        setVisible(true);

        displayGame();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                roundGui.refreshRoundFrame();
            }
        });

        whiteWonButton.addActionListener(e -> {
            try {
                tournament.getGameService().setWhiteWon(game);
                closeWindow();
            } catch (InvalidResultException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            refreshTable();
        });

        blackWonButton.addActionListener(e -> {
            try {
                tournament.getGameService().setBlackWon(game);
                closeWindow();
            } catch (InvalidResultException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            refreshTable();
        });

        drawButton.addActionListener(e -> {
            try {
                tournament.getGameService().setIsDrawn(game);
                closeWindow();
            } catch (InvalidResultException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            refreshTable();
        });
    }

    private void displayGame() {
        setUpTable();
        refreshTable();
    }

    private void refreshTable() {
        GameToGameGuiMapper gameToGameGuiMapper = new GameToGameGuiMapper();
        GameUiModel gameUiModel = gameToGameGuiMapper.map(game);
        tableModel.addRow(new Object[]{gameUiModel.getId(),
                gameUiModel.getWhitePlayer(),
                gameUiModel.getScore(),
                gameUiModel.getBlackPlayer()});

        revalidate();
        repaint();
    }

    private void setUpTable() {
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableModel.addColumn("GameId");
        tableModel.addColumn("White");
        tableModel.addColumn("Score");
        tableModel.addColumn("Black");

        gameTable.setModel(tableModel);
        gameTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        gameTable.setAutoCreateRowSorter(true);
    }

    private void closeWindow() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        roundGui.refreshRoundFrame();
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));
        gameLabel = new JLabel();
        gameLabel.setText("GameLabel");
        gamePanel.add(gameLabel, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gameTable = new JTable();
        gamePanel.add(gameTable, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        whiteWonButton = new JButton();
        whiteWonButton.setText("White Won");
        gamePanel.add(whiteWonButton, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        blackWonButton = new JButton();
        blackWonButton.setText("Black Won");
        gamePanel.add(blackWonButton, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        drawButton = new JButton();
        drawButton.setText("Draw");
        gamePanel.add(drawButton, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return gamePanel;
    }


}
