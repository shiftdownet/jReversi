
package model.reversi;

public class Referee {
    private Board board = null;
    private Agent agent1 = null;
    private Agent agent2 = null;
    private Disk disk = Disk.black;
    private Boolean passedInPrevTurn = false;

    public void prepareBoard(final Board board) {
        this.board = board;
        this.board.at(Board.D4).put(Disk.white);
        this.board.at(Board.D5).put(Disk.black);
        this.board.at(Board.E4).put(Disk.black);
        this.board.at(Board.E5).put(Disk.white);
    }

    public void accept(final Agent agent1, final Agent agent2) {
        this.agent1 = agent1;
        this.agent2 = agent2;
    }

    public void startGame() {
    }

    public boolean conductGame() {
        final Agent currentAgent = this.getAgentBy(this.disk);
        currentAgent.grasp(this.board);

        if (currentAgent.decided()) {
            final Position position = currentAgent.move();

            if (position == null) {
                if (this.passedInPrevTurn) {
                    return false;
                }
                passedInPrevTurn = true;
                this.disk = this.disk.back();
            } else {
                if (0 < this.board.put(this.disk, position)) {
                    passedInPrevTurn = false;
                    this.disk = this.disk.back();
                }
            }
        }

        return true;
    }

    private Agent getAgentBy(final Disk disk) {
        return (this.agent1.disk() == disk) ? this.agent1 : this.agent2;
    }

}