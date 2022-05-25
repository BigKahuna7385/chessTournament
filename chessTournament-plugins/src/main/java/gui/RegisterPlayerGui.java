package gui;

import player.Player;
import application.Tournament;
import application.exceptions.PlayerAlreadyRegistered;
import exceptions.*;
import transport.PlayerToPlayerUIMapper;
import transport.PlayerUiModel;
import transport.PlayerUiModelToPlayerMapper;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

public class RegisterPlayerGui extends JFrame {

    private final Tournament tournament;
    private final PlayerUiModelToPlayerMapper playerUiModelToPlayerMapper;
    private JTextField firstNameInput;
    private JTextField lastNameInput;
    private JTextField clubInput;
    private JTextField listNumberInput;
    private JTextField eloInput;
    private JTextField dwzInput;
    private JButton cancelButton;
    private JButton registerButton;
    private JPanel registerPlayerPanel;
    private JLabel jLabelTitle;
    private JButton deleteButton;
    private final TournamentGui tournamentGui;
    private int playerId;

    public RegisterPlayerGui(Tournament tournament, TournamentGui tournamentGui) {
        deleteButton.setVisible(false);
        setContentPane(registerPlayerPanel);
        this.tournament = tournament;
        this.tournamentGui = tournamentGui;
        playerUiModelToPlayerMapper = new PlayerUiModelToPlayerMapper();
        setSize(500, 500);
        setLocation(tournamentGui.getX() + 70, tournamentGui.getY() + 30);
        setTitle("Register Player");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                tournamentGui.setRegisterInProgress(false);
            }
        });

        cancelButton.addActionListener(e -> this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)));

        registerButton.addActionListener(e -> addPlayer());
    }


    private void addPlayer() {
        String firstName = firstNameInput.getText();
        String lastName = lastNameInput.getText();
        String clubName = clubInput.getText();
        int listNumber;
        try {
            listNumber = Integer.parseInt(listNumberInput.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Not a valid Number in Listnumber-field");
            return;
        }
        int elo;
        try {
            elo = Integer.parseInt(eloInput.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Not a valid Number in ELO-field");
            return;
        }

        int dwz;
        try {
            dwz = Integer.parseInt(dwzInput.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Not a valid Number in DWZ-field");
            return;
        }

        PlayerUiModel newPlayerUI = new PlayerUiModel(firstName, lastName, clubName, listNumber, elo, dwz, playerId > 0 ? playerId : tournament.getPlayerService().getNewId(), 0, 0, 0);

        try {
            try {
                Player newPlayer = playerUiModelToPlayerMapper.map(newPlayerUI);

                if (playerId == 0)
                    tournament.getPlayerService().createNewPlayer(newPlayer);
                else
                    tournament.getPlayerService().modifyPlayer(newPlayer);


            } catch (InvalidListNumberException e) {
                JOptionPane.showMessageDialog(null, "Listnumber must be integer larger than zero");
                return;
            } catch (InvalidRatingNumberException e) {
                JOptionPane.showMessageDialog(null, "Ratingnumber must be integer larger than zero");
                return;
            } catch (InvalidPlayerInfoException e) {
                JOptionPane.showMessageDialog(null, "There was an error in the player infos");
                return;
            } catch (InvalidPlayerNameExeption e) {
                JOptionPane.showMessageDialog(null, "Invalid player name");
                return;
            } catch (InvalidRatingException e) {
                JOptionPane.showMessageDialog(null, "The DWZ field must be filled");
                return;
            }
        } catch (PlayerAlreadyRegistered e) {

            JOptionPane.showMessageDialog(null, "This player has already been registered");
        }
        closeWindow();
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
        registerPlayerPanel = new JPanel();
        registerPlayerPanel.setLayout(new GridBagLayout());
        jLabelTitle = new JLabel();
        Font jLabelTitleFont = this.$$$getFont$$$(null, -1, 24, jLabelTitle.getFont());
        if (jLabelTitleFont != null) jLabelTitle.setFont(jLabelTitleFont);
        jLabelTitle.setText("Register player");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 11;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        registerPlayerPanel.add(jLabelTitle, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Club");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        registerPlayerPanel.add(label1, gbc);
        clubInput = new JTextField();
        clubInput.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 10;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        registerPlayerPanel.add(clubInput, gbc);
        lastNameInput = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 10;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        registerPlayerPanel.add(lastNameInput, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Lastname:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        registerPlayerPanel.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Firstname:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        registerPlayerPanel.add(label3, gbc);
        firstNameInput = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 10;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        registerPlayerPanel.add(firstNameInput, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Listnumber");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        registerPlayerPanel.add(label4, gbc);
        listNumberInput = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 10;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        registerPlayerPanel.add(listNumberInput, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("ELO");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        registerPlayerPanel.add(label5, gbc);
        cancelButton = new JButton();
        cancelButton.setBackground(new Color(-10027008));
        cancelButton.setText("Cancel");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 6;
        gbc.gridwidth = 7;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        registerPlayerPanel.add(cancelButton, gbc);
        registerButton = new JButton();
        registerButton.setBackground(new Color(-15449831));
        registerButton.setText("Register");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        registerPlayerPanel.add(registerButton, gbc);
        eloInput = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        registerPlayerPanel.add(eloInput, gbc);
        final JLabel label6 = new JLabel();
        label6.setText("DWZ");
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        registerPlayerPanel.add(label6, gbc);
        dwzInput = new JTextField();
        dwzInput.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        registerPlayerPanel.add(dwzInput, gbc);
        deleteButton = new JButton();
        deleteButton.setForeground(new Color(-4521965));
        deleteButton.setHideActionText(false);
        deleteButton.setText("Delete");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        registerPlayerPanel.add(deleteButton, gbc);
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
        return registerPlayerPanel;
    }

    public void changePlayer(int id) {
        preFillFormWith(tournament.getPlayerService().findPlayerById(id));
    }

    private void preFillFormWith(Player player) {
        deleteButton.setVisible(true);
        PlayerToPlayerUIMapper playerToPlayerUIMapper = new PlayerToPlayerUIMapper();
        PlayerUiModel playerUiModel = playerToPlayerUIMapper.map(player);
        jLabelTitle.setText("Change Player Info");
        firstNameInput.setText(playerUiModel.getFirstName());
        lastNameInput.setText(playerUiModel.getLastName());
        clubInput.setText(playerUiModel.getClubName());
        listNumberInput.setText(String.valueOf(playerUiModel.getListNumber()));
        eloInput.setText(String.valueOf(playerUiModel.getElo()));
        dwzInput.setText(String.valueOf(playerUiModel.getDwz()));
        playerId = player.getId();

        deleteButton.addActionListener(e -> {
            tournament.getPlayerService().removePlayer(player);
            closeWindow();
        });
    }

    private void closeWindow() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        tournamentGui.refreshPlayerList();
    }
}
