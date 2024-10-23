package pilha;

import java.util.Stack;

public class TestePilhaStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("Mauricio");
        stack.push("Marcelo");

        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        String nome = stack.peek();
        System.out.println(nome);
    }
}
