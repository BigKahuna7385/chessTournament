package gui;

import application.exceptions.GameAlreadyAddedException;
import application.exceptions.PlayerNotRegisteredException;
import player.Player;
import application.Tournament;
import application.exceptions.TournamentServicesAreNotInitializedException;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import transport.PlayerToPlayerUIMapper;
import transport.PlayerUiModel;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;

public class TournamentGui extends JFrame {
    private JTable registeredPlayerTable;
    private JButton addPlayerButton;
    private JButton startButton;
    private JPanel tournamentPanel;
    private JButton standingsButton;

    private final Tournament tournament;

    private boolean registerInProgress;

    private DefaultTableModel tableModel;

    private final TournamentGui tournamentGui;

    public TournamentGui(Tournament tournament) {
        this.tournament = tournament;
        registerInProgress = false;
        this.tournamentGui = this;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(tournamentPanel);
        setTitle("Tournament-Manager");
        setSize(500, 500);
        setVisible(true);

        setUpTable();

        addPlayerButton.addActionListener(e -> {
            if (!registerInProgress) {
                new RegisterPlayerGui(tournament, this);
                setRegisterInProgress(true);
            }
        });

        startButton.addActionListener(e -> {
            try {
                tournament.startTournament();
                new RoundGui(tournament, this);
            } catch (TournamentServicesAreNotInitializedException | GameAlreadyAddedException |
                     PlayerNotRegisteredException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
    }

    private void setUpTable() {
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableModel.addColumn("Id");
        tableModel.addColumn("player");
        tableModel.addColumn("Club");
        tableModel.addColumn("ELO");
        tableModel.addColumn("DWZ");

        registeredPlayerTable.setModel(tableModel);
        registeredPlayerTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        registeredPlayerTable.setAutoCreateRowSorter(true);

        registeredPlayerTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    JTable target = (JTable) me.getSource();
                    int row = target.getSelectedRow();
                    RegisterPlayerGui registerPlayerGui = new RegisterPlayerGui(tournament, tournamentGui);
                    registerPlayerGui.changePlayer((Integer) registeredPlayerTable.getValueAt(row, 0));
                }
            }
        });

    }


    public void setRegisterInProgress(boolean registerInProgress) {
        addPlayerButton.setEnabled(!registerInProgress);
        this.registerInProgress = registerInProgress;
    }

    public void refreshPlayerList() {
        PlayerToPlayerUIMapper playerToPlayerUIMapper = new PlayerToPlayerUIMapper();

        tableModel.setRowCount(0);

        for (Player player : tournament.getPlayerService().getAllRegisteredPlayers()) {
            PlayerUiModel playerUiModel = playerToPlayerUIMapper.map(player);
            tableModel.addRow(new Object[]{playerUiModel.getId(), playerUiModel.getFullName(), playerUiModel.getClubName(), playerUiModel.getElo(), playerUiModel.getDwz()});
        }

        revalidate();
        repaint();
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
        tournamentPanel = new JPanel();
        tournamentPanel.setLayout(new GridLayoutManager(5, 2, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, Font.BOLD, 26, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Chess Tournament Manager");
        tournamentPanel.add(label1, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        tournamentPanel.add(scrollPane1, new GridConstraints(1, 1, 4, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        registeredPlayerTable = new JTable();
        scrollPane1.setViewportView(registeredPlayerTable);
        addPlayerButton = new JButton();
        addPlayerButton.setText("Add player");
        tournamentPanel.add(addPlayerButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        startButton = new JButton();
        startButton.setText("Start");
        tournamentPanel.add(startButton, new GridConstraints(2, 0, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        return tournamentPanel;
    }

}
