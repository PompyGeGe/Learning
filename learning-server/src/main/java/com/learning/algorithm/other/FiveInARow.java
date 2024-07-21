package com.learning.algorithm.other;

import javax.swing.*;
import java.awt.*;

/**
 * 【五子棋 简单的迭代算法就可实现！】
 * 此文可了解迭代和循环的区别：
 * https://blog.csdn.net/u014775977/article/details/53930052?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-1-53930052-blog-126947159.235^v43^pc_blog_bottom_relevance_base2&spm=1001.2101.3001.4242.2&utm_relevant_index=4
 */
public class FiveInARow extends JFrame {
    private final int ROWS = 15;
    private final int COLS = 15;
    private JButton[][] board;
    private boolean isBlackTurn = true;

    public FiveInARow() {
        setTitle("Five in a Row");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new JButton[ROWS][COLS];

        setLayout(new GridLayout(ROWS, COLS));

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = new JButton();
                board[i][j].setBackground(Color.LIGHT_GRAY);
                final int row = i;
                final int col = j;
                board[i][j].addActionListener(e -> placePiece(row, col));
                add(board[i][j]);
            }
        }

        setVisible(true);
    }

    private void placePiece(int row, int col) {
        if (board[row][col].getBackground() == Color.LIGHT_GRAY) {
            Color color = isBlackTurn ? Color.BLACK : Color.WHITE;
            board[row][col].setBackground(color);
            if (checkWin(row, col)) {
                String winner = isBlackTurn ? "Black" : "White";
                JOptionPane.showMessageDialog(null, winner + " wins!");
                resetBoard();
            } else {
                isBlackTurn = !isBlackTurn;
            }
        }
    }

    private boolean checkWin(int row, int col) {
        Color color = isBlackTurn ? Color.BLACK : Color.WHITE;

        // Check horizontally
        int count = 1;
        for (int i = col - 1; i >= 0 && board[row][i].getBackground() == color; i--) {
            count++;
        }
        for (int i = col + 1; i < COLS && board[row][i].getBackground() == color; i++) {
            count++;
        }
        if (count >= 5) {
            return true;
        }

        // Check vertically
        count = 1;
        for (int i = row - 1; i >= 0 && board[i][col].getBackground() == color; i--) {
            count++;
        }
        for (int i = row + 1; i < ROWS && board[i][col].getBackground() == color; i++) {
            count++;
        }
        if (count >= 5) {
            return true;
        }

        return false;
    }

    private void resetBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j].setBackground(Color.LIGHT_GRAY);
            }
        }
        isBlackTurn = true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FiveInARow());
    }
}