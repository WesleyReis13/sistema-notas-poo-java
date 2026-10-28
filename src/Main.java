import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Sistema de Registro de Notas Escolares ---");
        System.out.print("Quantos alunos serão cadastrados? ");
        int quantidadeAlunos = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do teclado


        Aluno[] alunos = new Aluno[quantidadeAlunos];


        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.println("\n--- Cadastro do " + (i + 1) + "º Aluno ---");
            System.out.print("Digite o nome do aluno: ");
            String nome = scanner.nextLine();

            System.out.print("Quantas notas o aluno " + nome + " terá no ano? ");
            int quantidadeNotas = scanner.nextInt();


            double[] notas = new double[quantidadeNotas];


            for (int j = 0; j < quantidadeNotas; j++) {
                double notaTemp;
                do {
                    System.out.print("Digite a " + (j + 1) + "ª nota (entre 0 e 10): ");
                    notaTemp = scanner.nextDouble();


                    if (notaTemp < 0 || notaTemp > 10) {
                        System.out.println("[Erro] Nota inválida! A nota deve estar entre 0 e 10. Tente novamente.");
                    }
                } while (notaTemp < 0 || notaTemp > 10);

                notas[j] = notaTemp;
            }
            scanner.nextLine();


            alunos[i] = new Aluno(nome, notas);
        }


        System.out.println("\n\n========================================");
        System.out.println("       RELATÓRIO FINAL DE NOTAS         ");
        System.out.println("========================================");

        for (Aluno aluno : alunos) {
            System.out.println("Aluno: " + aluno.getNome());
            System.out.print("Notas: ");

            double[] notasAluno = aluno.getNotas();
            for (int k = 0; k < notasAluno.length; k++) {
                System.out.print(notasAluno[k]);
                if (k < notasAluno.length - 1) {
                    System.out.print(", ");
                }
            }


            System.out.printf("\nMédia: %.2f\n", aluno.calcularMedia());
            System.out.println("----------------------------------------");
        }

        scanner.close();
    }
}
