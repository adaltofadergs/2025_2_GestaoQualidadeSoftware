import org.example.base.BaseTest;
import org.example.page.CadastroProdutoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CadastroProdutoTest extends BaseTest {

    @Test
    public void validarLinks(){
        CadastroProdutoPage page = new  CadastroProdutoPage( getDriver() );
        Assert.assertEquals( page.clicarGoogle(),
                "https://www.google.com/" );
        Assert.assertEquals( page.clicarGZH() ,
                "Empresas: Últimas Notícias | GZH");
    }

    @Test
    public void validarCadastro(){
        CadastroProdutoPage page = new CadastroProdutoPage( getDriver() );
        String resultadoFinal = page.informarNome( "Detergente" )
                .informarCategoria("Higiene")
                .selecionarCanalVenda("E-Commerce" , "Loja Física" , "Telefone")
                .informarEstoqueMinimo("5")
                .informarEstoqueMaximo( 25 )
                .selecionarVendaImediataSim()
                .selecionarFormaCaixa()
                .selecionarFormaUnidade()
                .clicarCadastrar()
                .buscarResutadoCadastro();
        Assert.assertTrue( resultadoFinal.contains("Nome: Detergente") );
        Assert.assertTrue( resultadoFinal.contains("Categoria:higiene") );
        //Assert.assertTrue( resultadoFinal.contains("Canais de Venda: E-Commerce Loja Física Telefone") );
        Assert.assertTrue( resultadoFinal.contains("Commerce Loja") );
        Assert.assertTrue( resultadoFinal.contains("Estoque Mínimo: 5") );
        Assert.assertTrue( resultadoFinal.contains("Estoque Mánimo: 25.0") );
        Assert.assertTrue(
                resultadoFinal.contains("Disponibilizar para venda imediata?: sim") );
        Assert.assertTrue( resultadoFinal.contains("Formas de Venda: Unidade Caixa") );
    }


}
