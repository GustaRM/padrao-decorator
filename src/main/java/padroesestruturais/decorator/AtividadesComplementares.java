package padroesestruturais.decorator;

/** Papel "ConcreteDecorator". */
public class AtividadesComplementares extends CursoDecorator {

    public AtividadesComplementares(Curso curso) {
        super(curso);
    }

    @Override
    protected float getPercentualCargaHoraria() {
        return 20.0f;
    }

    @Override
    protected String getNomeEstrutura() {
        return "ACC";
    }
}
