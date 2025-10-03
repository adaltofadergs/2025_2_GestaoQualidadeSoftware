package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CadastroProdutoPage extends BasePage {

    @FindBy( id = "txt01" )
    private WebElement txtNomeProduto;

    @FindBy( id = "categoria")
    private WebElement selCategoria;

    @FindBy( id = "venda")
    private WebElement selCanalVenda;

    @FindBy( id = "txt02")
    private WebElement txtEstoqueMinimo;

    @FindBy( xpath = "/html/body/div/form/fieldset/div[5]/input")
    private WebElement txtEstoqueMaximo;

    @FindBy( id = "sim")
    private WebElement rbSim;

    @FindBy( id = "nao")
    private WebElement rbNao;

    @FindBy( xpath = "/html/body/div/form/div[3]/label/input")
    private WebElement cbUnidade;

    @FindBy( xpath = "/html/body/div/form/div[4]/label/input")
    private WebElement cbCaixa;

    @FindBy( xpath = "/html/body/div/form/div[5]/label/input")
    private WebElement cbPacote;

    @FindBy( xpath = "/html/body/div/form/div[6]/label/input")
    private WebElement cbDuzia;

    @FindBy( id = "elementosForm:cadastrar")
    private WebElement btnCadastrar;

    @FindBy( linkText = "google")
    private WebElement linkGoogle;

    @FindBy( partialLinkText = "GZH")
    private WebElement linkGZH;

    public CadastroProdutoPage(WebDriver driver){
        super( driver );
    }


    public CadastroProdutoPage informarNome( String nome ){
        txtNomeProduto.sendKeys( nome );
        return this;
    }

    public CadastroProdutoPage informarEstoqueMinimo( String estoqueMinimo ){
        txtEstoqueMinimo.sendKeys( estoqueMinimo );
        return this;
    }

    public CadastroProdutoPage informarEstoqueMaximo( String estoqueMaximo ){
        txtEstoqueMaximo.sendKeys( estoqueMaximo );
        return this;
    }

    public CadastroProdutoPage informarEstoqueMaximo( double estoqueMaximo ){
        txtEstoqueMaximo.sendKeys( String.valueOf( estoqueMaximo ) );
        return this;
    }

    public CadastroProdutoPage informarCategoria( String categoria ){
        Select dropdown = new Select( selCategoria );
        dropdown.selectByVisibleText( categoria );
        return this;
    }

    public CadastroProdutoPage informarCategoria( int indexCategoria ){
        Select dropdown = new Select( selCategoria );
        dropdown.selectByIndex( indexCategoria );
        return this;
    }



}
