package padroesestruturais.decorator;

public class Main {

    public static void main(String[] args) {
        Curso curso = new Estagio(new AtividadesComplementares(
                new TrabalhoConclusaoCurso(new CursoGraduacao(1000.0f))));

        System.out.println(curso.getEstrutura());
        System.out.println(curso.getCargaHoraria() + " horas");
    }
}
