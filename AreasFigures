public class AreasFigures {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell me the base");
        int BaseNumber = scanner.nextInt();
        System.out.println("Tell me the height");
        int HeightNumber = scanner.nextInt();
        System.out.println("Tell me if it is a square, rectangle or triangle");
        scanner.nextLine();
        String NameFigure =scanner.nextLine();
        if ("triangle".equals(NameFigure)) {
            int TriangleArea = (HeightNumber * BaseNumber) / 2;
            System.out.println("It is a Triangle with area" + TriangleArea);
        } else if ("Rectangle".equals(NameFigure)) {
            int RectangleArea = BaseNumber * HeightNumber;
            System.out.println("It is a Rectangle with area" + RectangleArea);
        } else if ("square".equals(NameFigure)) {
            int SquareArea = BaseNumber * HeightNumber;
            System.out.println("It is a square with area" + SquareArea);
        } else {
            System.out.println("if it is not one of these figures, it will not be valid");
        }

    }
}
