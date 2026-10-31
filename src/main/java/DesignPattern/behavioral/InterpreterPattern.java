package DesignPattern.behavioral;

public class InterpreterPattern {

    interface Expression {
        int interpret();
    }

    static class NumberExpression implements Expression {

        private final int number;

        public NumberExpression(int number) {
            this.number = number;
        }

        @Override
        public int interpret() {
            return number;
        }
    }

    static class AddExpression implements Expression {

        private final Expression left;
        private final Expression right;

        public AddExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpret() {
            return left.interpret() + right.interpret();
        }
    }

    static class SubExpression implements Expression {

        private final Expression left;
        private final Expression right;

        public SubExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpret() {
            return left.interpret() - right.interpret();
        }
    }

    public static void main(String[] args) {

        Expression five = new NumberExpression(5);
        Expression three = new NumberExpression(3);
        Expression two = new NumberExpression(2);

        Expression addition = new AddExpression(five, three);
        Expression subtraction = new SubExpression(addition, two);

        System.out.println("Addition Result: " + addition.interpret());
        System.out.println("Final Result: " + subtraction.interpret());
    }
}