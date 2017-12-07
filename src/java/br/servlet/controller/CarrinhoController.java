package br.servlet.controller;

import br.servlet.dao.CategoriaDao;
import br.servlet.dao.ClienteDao;
import br.servlet.dao.CompraDao;
import br.servlet.dao.ProdutoDao;
import br.servlet.model.Cliente;
import br.servlet.model.Compra;
import br.servlet.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CarrinhoController extends HttpServlet {


    private ProdutoDao dao;
    private CategoriaDao cat_dao;
    private CompraDao comp_dao;
    private ClienteDao cli_dao;
 
    public CarrinhoController() {
        super();
        dao = new ProdutoDao();
        cat_dao = new CategoriaDao();
        comp_dao = new CompraDao();
        cli_dao = new ClienteDao();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.setAttribute("carrinho", (List<Produto>) session.getAttribute("carrinho"));
        request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
        
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(request.getParameterMap().containsKey("deleta_id")){
        
            List<Produto> carrinho = (List<Produto>) session.getAttribute("carrinho");
            
            
            for(int i = 0; i < carrinho.size(); i++)
            {
                Produto p = carrinho.get(i);

                if(p.getId() == Integer.parseInt(request.getParameter("deleta_id")))
                {
                    carrinho.remove(p);

                }
            }
            session.setAttribute("carrinho", carrinho);
            request.setAttribute("carrinho", carrinho);
            request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
            
        }
        
        else {
            Cliente cliente = new Cliente();
                String nome = request.getParameter("nome");
                String end = request.getParameter("endereco");
                String cep = request.getParameter("cep");
                String est = request.getParameter("estado");
                String ref = request.getParameter("referencia");
                String cpf = request.getParameter("cpf");
                String rg = request.getParameter("rg");
                String tel = request.getParameter("telefone");
                String cel = request.getParameter("celular");
                String cart = request.getParameter("cartao");
                String band = request.getParameter("bandeira");

                cliente.setNome(nome);
                cliente.setEndereco(end);
                cliente.setCep(cep);
                cliente.setEstado(est);
                cliente.setReferencia(ref);
                cliente.setCpf(cpf);
                cliente.setRg(rg);
                cliente.setTelefone(tel);
                cliente.setCelular(cel);
                cliente.setCartao(cart);
                cliente.setBandeira(band);
                cli_dao.addCliente(cliente);

            List<Cliente> Clientes = cli_dao.getClientes();

            List<Produto> Carrinho = (List<Produto>) session.getAttribute("carrinho");

            Compra compra = new Compra();
            compra.setCliente(Clientes.get(Clientes.size()-1));

            for (int i = 0; i < Carrinho.size(); i++ ){
                compra.setProduto(Carrinho.get(i));
                comp_dao.addCompra(compra);
            }

            session.invalidate();
            request.getRequestDispatcher("/comprafinalizada.jsp").forward(request, response);
        }
    }
    
}