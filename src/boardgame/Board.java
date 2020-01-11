/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

/**
 *
 * @author Cliente
 */
public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Linha e columas deve ser maiores ou igual a 1");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        if (!PositionExists(row, column)) {
            throw new BoardException("Posição não existe !");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!PositionExists(position)) {
            throw new BoardException("Posição não existe !");
        }

        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (ThereIsAPiece(position)) {
            throw new BoardException("Há uma peça ai" + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public boolean PositionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && row < columns;
    }

    public boolean PositionExists(Position position) {
        return PositionExists(position.getRow(), position.getColumn());
    }

    public boolean ThereIsAPiece(Position position) {
        if (!PositionExists(position)) {
            throw new BoardException("Posição não existe !");
        }

        return piece(position) != null;

    }
}
