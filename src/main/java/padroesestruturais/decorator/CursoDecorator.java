package padroesestruturais.decorator;

import java.util.Objects;

/**
 * Papel "Decorator": implementa Curso e guarda uma referência a outro Curso.
 * Usa Template Method: a lógica de composição fica aqui e cada decorador
 * concreto informa apenas seu percentual e seu nome.
 */
public abstract class CursoDecorator implements Curso {

    private final Curso curso;

    protected CursoDecorator(Curso curso) {
        this.curso = Objects.requireNonNull(curso, "O curso decorado não pode ser nulo");
    }

    public Curso getCurso() {
        return curso;
    }

    protected abstract float getPercentualCargaHoraria();

    protected abstract String getNomeEstrutura();

    @Override
    public float getCargaHoraria() {
        return this.curso.getCargaHoraria() * (1 + (this.getPercentualCargaHoraria() / 100));
    }

    @Override
    public String getEstrutura() {
        return this.curso.getEstrutura() + "/" + this.getNomeEstrutura();
    }
}
