package padroesestruturais.decorator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Testes adicionais: contrato do Decorator e casos de borda. */
class CursoDecoratorTest {

    private static final float DELTA = 0.01f;

    @Test
    void decoradorNaoAceitaCursoNulo() {
        assertThrows(NullPointerException.class, () -> new Estagio(null));
        assertThrows(NullPointerException.class, () -> new AtividadesComplementares(null));
        assertThrows(NullPointerException.class, () -> new TrabalhoConclusaoCurso(null));
    }

    @Test
    void decoradorEhUmCurso() {
        Curso curso = new Estagio(new CursoGraduacao(1000.0f));
        assertTrue(curso instanceof Curso);
        assertTrue(curso instanceof CursoDecorator);
    }

    @Test
    void getCursoRetornaOComponenteDecorado() {
        Curso base = new CursoGraduacao(1000.0f);
        CursoDecorator decorado = new Estagio(base);
        assertSame(base, decorado.getCurso());
    }

    @Test
    void decoradorNaoAlteraOCursoOriginal() {
        Curso base = new CursoGraduacao(1000.0f);
        new Estagio(base);
        assertEquals(1000.0f, base.getCargaHoraria());
        assertEquals("Graduação", base.getEstrutura());
    }

    @Test
    void mesmoDecoradorPodeSerAplicadoDuasVezes() {
        Curso curso = new Estagio(new Estagio(new CursoGraduacao(1000.0f)));
        assertEquals(1210.0f, curso.getCargaHoraria(), DELTA);
        assertEquals("Graduação/Estágio/Estágio", curso.getEstrutura());
    }

    @Test
    void ordemDosDecoradoresNaoAlteraACargaHoraria() {
        Curso a = new Estagio(new AtividadesComplementares(new CursoGraduacao(1000.0f)));
        Curso b = new AtividadesComplementares(new Estagio(new CursoGraduacao(1000.0f)));
        assertEquals(a.getCargaHoraria(), b.getCargaHoraria(), DELTA);
    }

    @Test
    void ordemDosDecoradoresAlteraAEstrutura() {
        Curso a = new Estagio(new AtividadesComplementares(new CursoGraduacao()));
        Curso b = new AtividadesComplementares(new Estagio(new CursoGraduacao()));
        assertEquals("Graduação/ACC/Estágio", a.getEstrutura());
        assertEquals("Graduação/Estágio/ACC", b.getEstrutura());
    }

    @Test
    void cursoSemCargaHorariaPermaneceZeradoMesmoDecorado() {
        Curso curso = new Estagio(new AtividadesComplementares(new CursoGraduacao()));
        assertEquals(0.0f, curso.getCargaHoraria(), DELTA);
    }

    @Test
    void cadaDecoradorAplicaSeuPercentual() {
        assertEquals(1100.0f, new Estagio(new CursoGraduacao(1000.0f)).getCargaHoraria(), DELTA);
        assertEquals(1200.0f, new AtividadesComplementares(new CursoGraduacao(1000.0f)).getCargaHoraria(), DELTA);
        assertEquals(1050.0f, new TrabalhoConclusaoCurso(new CursoGraduacao(1000.0f)).getCargaHoraria(), DELTA);
    }

    @Test
    void decoradoresSaoIndependentesEntreInstancias() {
        Curso engenharia = new Estagio(new CursoGraduacao(3600.0f));
        Curso direito = new TrabalhoConclusaoCurso(new CursoGraduacao(3700.0f));
        assertEquals(3960.0f, engenharia.getCargaHoraria(), DELTA);
        assertEquals(3885.0f, direito.getCargaHoraria(), DELTA);
        assertEquals("Graduação/Estágio", engenharia.getEstrutura());
        assertEquals("Graduação/TCC", direito.getEstrutura());
    }
}
