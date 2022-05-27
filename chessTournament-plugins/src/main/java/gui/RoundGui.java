package gui;

import application.exceptions.*;
import game.Game;
import application.Tournament;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import transport.GameToGameGuiMapper;
import transport.GameUiModel;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;

public class RoundGui extends JFrame {
    private final Tournament tournament;
    private final TournamentGui tournamentGui;
    private JLabel roundNumber;
    private JTable roundTable;
    private JButton closeRoundButton;
    private JButton nextRoundButton;
    private JPanel roundPanel;
    private JScrollPane standingsPanel;
    private JScrollPane crossTablePanel;
    private DefaultTableModel tableModel;
    private final RoundGui roundGui;
    private StandingsGui standingsGui;
    private CrossTableGui crossTableGui;

    public RoundGui(Tournament tournament, TournamentGui tournamentGui) {
        this.tournament = tournament;
        this.tournamentGui = tournamentGui;
        this.roundGui = this;
        standingsGui = new StandingsGui(tournament);
        crossTableGui = new CrossTableGui(tournament);
        setContentPane(roundPanel);
        setTitle("Round Manager");
        setSize(1000, 1000);
        setVisible(true);

        displayRound();
        standingsPanel.setViewportView(standingsGui.getStandingsPanel());
        crossTablePanel.setViewportView(crossTableGui.getCrossTablePanel());

        closeRoundButton.addActionListener(e -> {
            try {
                tournament.getRoundService().closeRound();
                nextRoundButton.setEnabled(true);
                closeRoundButton.setEnabled(false);
            } catch (NotAllGamesAreFinishedException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        nextRoundButton.addActionListener(e -> {
            try {
                tournament.getRoundService().createNextRound();
                nextRoundButton.setEnabled(false);
                closeRoundButton.setEnabled(true);
                refreshRoundFrame();
            } catch (CurrentRoundIsNotClosedException | GameAlreadyAddedException | PlayerNotRegisteredException | RuntimeException | NoMorePossibleOpponentsException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });


    }

    private void displayRound() {
        setUpTable();
        refreshRoundFrame();
    }

    public void refreshRoundFrame() {
        refreshGameList();
        standingsGui.refreshGamesList();
        crossTableGui.refreshGamesList();
        roundNumber.setText("Round N° " + tournament.getRoundService().getCurrentRoundNumber());
        revalidate();
        repaint();
    }


    private void refreshGameList() {
        GameToGameGuiMapper gameToGameGuiMapper = new GameToGameGuiMapper();

        tableModel.setRowCount(0);

        for (Game game : tournament.getGameService().getAllGamesIn(tournament.getRoundService().getCurrentRound())) {
            GameUiModel gameUiModel = gameToGameGuiMapper.map(game);
            tableModel.addRow(new Object[]{gameUiModel.getId(), gameUiModel.getWhitePlayer(), gameUiModel.getScore(), gameUiModel.getBlackPlayer()});
        }
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

        roundTable.setModel(tableModel);
        roundTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        roundTable.setAutoCreateRowSorter(true);

        roundTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    JTable target = (JTable) me.getSource();
                    int row = target.getSelectedRow();
                    Game clickedGame = tournament.getGameService().getGameById((Integer) roundTable.getValueAt(row, 0));
                    new GameGui(tournament, roundGui, clickedGame);
                }
            }
        });
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
        roundPanel = new JPanel();
        roundPanel.setLayout(new GridLayoutManager(4, 3, new Insets(0, 0, 0, 0), -1, -1));
        roundNumber = new JLabel();
        Font roundNumberFont = this.$$$getFont$$$(null, Font.BOLD, 26, roundNumber.getFont());
        if (roundNumberFont != null) roundNumber.setFont(roundNumberFont);
        roundNumber.setText("Label");
        roundPanel.add(roundNumber, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        roundPanel.add(scrollPane1, new GridConstraints(1, 0, 2, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        roundTable = new JTable();
        scrollPane1.setViewportView(roundTable);
        closeRoundButton = new JButton();
        closeRoundButton.setText("Close round");
        roundPanel.add(closeRoundButton, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nextRoundButton = new JButton();
        nextRoundButton.setEnabled(false);
        nextRoundButton.setText("Next round");
        roundPanel.add(nextRoundButton, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        standingsPanel = new JScrollPane();
        roundPanel.add(standingsPanel, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        crossTablePanel = new JScrollPane();
        roundPanel.add(crossTablePanel, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return roundPanel;
    }

}
