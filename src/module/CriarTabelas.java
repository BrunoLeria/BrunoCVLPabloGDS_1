/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class CriarTabelas {
    private String url;
    private String usuario;
    private String senha;
    private String driver;
    private Connection conexao;
    private Statement sessao;
    
    public void conectar() {
        try {
            setUrl("jdbc:mysql://localhost:3306/loo");
            setUsuario("root");
            setSenha("root");
            setDriver("com.mysql.cj.jdbc.Driver");
            Class.forName(getDriver());
            setConexao(DriverManager.getConnection(getUrl(), getUsuario(), getSenha()));
            System.out.println("Conexão realizada");
        } catch (ClassNotFoundException ex) {
            System.err.println("Excessão de classe não encontrada");
        } catch (SQLException ex) {
            System.err.println("Excessão de SQL na hora de conectar ao banco");
        }
    }

    public void criarTabela(String sql) {
        try {
            setSessao(getConexao().createStatement());
            int rs = getSessao().executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println("Excessão de SQL ao enviar requisição ao banco");
        }
    }

    public static void main(String args[]) {

    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the conexao
     */
    public Connection getConexao() {
        return conexao;
    }

    /**
     * @param conexao the conexao to set
     */
    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * @return the sessao
     */
    public Statement getSessao() {
        return sessao;
    }

    /**
     * @param sessao the sessao to set
     */
    public void setSessao(Statement sessao) {
        this.sessao = sessao;
    }
}
