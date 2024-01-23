import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TicTacToeGame extends JFrame{
    
    private JButton[][] buttons = new JButton[3][3];
    private boolean isPlayerX = true; // Flag to track the current player
    
    public TicTacToeGame() {
        
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
            
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].addActionListener(new ButtonClickListener());
                add(buttons[i][j]);
            }
        
        setVisible(true);
        }
    
    }
    
    
    class ButtonClickListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            
            JButton source = (JButton) e.getSource();
            if(source.getText().equals("") && !isGameOver()) {
                
                if(isPlayerX) source.setText("X");
                else source.setText("O");
                
                isPlayerX = !isPlayerX;
                
                if(checkForWinner()) {
                
                    JOptionPane.showMessageDialog(null,  (isPlayerX ? "O wins!!!...:)": "X wins!!!...:)"));
                    
                }
                 else if (isBoardFull()) {
                    JOptionPane.showMessageDialog(null, "It's a draw!");
                    resetGame();
                }



            }
                
            }
            
        }
    
    
    
    
    // Inside the TicTacToeGame class

// Implement the checkForWinner method
private boolean checkForWinner() {
    // Check rows
    for (int i = 0; i < 3; i++) {
        if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
            buttons[i][0].getText().equals(buttons[i][2].getText()) &&
            !buttons[i][0].getText().equals("")) {
            return true;
        }
    }

    // Check columns
    for (int j = 0; j < 3; j++) {
        if (buttons[0][j].getText().equals(buttons[1][j].getText()) &&
            buttons[0][j].getText().equals(buttons[2][j].getText()) &&
            !buttons[0][j].getText().equals("")) {
            return true;
        }
    }

    // Check diagonals
    if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
        buttons[0][0].getText().equals(buttons[2][2].getText()) &&
        !buttons[0][0].getText().equals("")) {
        return true;
    }

    if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
        buttons[0][2].getText().equals(buttons[2][0].getText()) &&
        !buttons[0][2].getText().equals("")) {
        return true;
    }

    return false;
}

// Implement the isBoardFull method
private boolean isBoardFull() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (buttons[i][j].getText().equals("")) {
                return false; // Found an empty cell, board is not full
            }
        }
    }
    return true; // No empty cells found, board is full
}

// Implement the resetGame method
private void resetGame() {
    // Reset button texts
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            buttons[i][j].setText("");
        }
    }

    // Reset player turn flag
    isPlayerX = true;
}

// Implement the isGameOver method (optional)
private boolean isGameOver() {
    return checkForWinner() || isBoardFull();
}

    
    public static void main(String[] args) {
    
        SwingUtilities.invokeLater(() -> {
            
            new TicTacToeGame();
        
        });
    
    }
    
}

