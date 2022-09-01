package br.com.rldcarvalho.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class MonitoramentoFilter
 */
//@WebFilter("/entrada")
public class MonitoramentoFilter extends HttpFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    	System.out.println("MonitoramentoFilter");

		long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");

		// executa a ação
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		System.out.println("Tempo de execução da ação " + acao + " -> "+ (depois - antes));
	}

	

}
