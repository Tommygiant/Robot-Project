public class Robot {
    int x;
    int y;

    public Robot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(char direct, int n) {
        switch (direct) {
            case 'L':
                x = (x + 1) % n;
                break;
            case 'R':
                x = (x - 1 + n) % n;
                break;
            case 'D':
                y = (y - 1 + n) % n;
                break;
            case 'U':
                y = (y + 1) % n;
                break;
        }
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}