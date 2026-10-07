package padroesestruturais.decorator;

/** Papel "ConcreteComponent": o curso base, que será decorado. */
public class CursoGraduacao implements Curso {

    private final float cargaHoraria;

    public CursoGraduacao() {
        this(0.0f);
    }

    public CursoGraduacao(float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public float getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public String getEstrutura() {
        return "Graduação";
    }
}
