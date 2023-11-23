public class TreeRenderer {
    public Integer height = 0;
    public Integer trunkWidth = 3;
    public Integer trunkHeight = 2;

    public TreeRenderer(Integer height) {
        this.height = height;
    }

    public TreeRenderer(Integer height, Integer trunkWidth, Integer trunkHeight) {
        this.height = height;
        this.trunkWidth = trunkWidth;
        this.trunkHeight = trunkHeight;
    }

    public String render() {
        String result = "";
        // Tree
        for (int i = 0; i < this.height; i++) {
            result += " ".repeat(this.height - i - 1);
            result += "*".repeat(i * 2 + 1);
            result += "\n";
        }
        // Trunk
        for (int i = 0; i < this.trunkHeight; i++) {
            result += " ".repeat(this.height - this.trunkWidth / 2 - 1);
            result += "*".repeat(this.trunkWidth);
            result += "\n";
        }
        return result;
    }

    public void print() {
        System.out.println(this.render());
    }
}
