package padroesestruturais.decorator;

/** Papel "ConcreteDecorator". */
public class TrabalhoConclusaoCurso extends CursoDecorator {

    public TrabalhoConclusaoCurso(Curso curso) {
        super(curso);
    }

    @Override
    protected float getPercentualCargaHoraria() {
        return 5.0f;
    }

    @Override
    protected String getNomeEstrutura() {
        return "TCC";
    }
}
