package com.mercado.inteligente.dao;
import java.util.List;

public interface GenericDAO<T> {
    void salvar(T obj);
    void atualizar(T obj);
    void deletar(Long id);
    T buscarPorId(Long id);
    List<T> listarTodos();
}