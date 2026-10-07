package padroesestruturais.decorator;

/** Papel "ConcreteDecorator". */
public class Estagio extends CursoDecorator {

    public Estagio(Curso curso) {
        super(curso);
    }

    @Override
    protected float getPercentualCargaHoraria() {
        return 10.0f;
    }

    @Override
    protected String getNomeEstrutura() {
        return "Estágio";
    }
}
