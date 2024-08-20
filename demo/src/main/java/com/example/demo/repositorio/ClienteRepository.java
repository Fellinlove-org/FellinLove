package com.example.demo.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Cliente;


@Repository
public class ClienteRepository {
    private Map<Integer, Cliente> clientes = new HashMap<>();

    public ClienteRepository() {
        clientes.put(1, new Cliente(1, 264872648, "Esteban", "Calle 1", "5555555", "https://images.stockcake.com/public/1/3/4/1347c67e-54fe-45cd-8131-c2903a3fca79_large/intense-focused-face-stockcake.jpg"));
        clientes.put(2, new Cliente(2, 782368473, "Luis", "Calle 2", "5555555","https://images.stockcake.com/public/9/8/d/98dd7a4f-8b2d-4f88-b5f6-4bb0672bc212_large/elderly-gentle-smile-stockcake.jpg" ));
        clientes.put(3, new Cliente(3, 374284675, "Esteban", "Calle 1", "5555555", "https://images.stockcake.com/public/9/8/7/987c0082-388d-449f-b944-713f54aeb002_large/mud-covered-piercing-gaze-stockcake.jpg"));
        clientes.put(4, new Cliente(4, 374632754, "Luis", "Calle 2", "5555555", "https://images.stockcake.com/public/6/2/4/624dcf43-c90a-4481-9e4f-86c8b69ce68f_large/intense-clown-portrait-stockcake.jpg"));
        clientes.put(5, new Cliente(5, 874678236, "Esteban", "Calle 1", "5555555","https://images.stockcake.com/public/4/1/f/41f73698-6b90-4b4f-bf00-ebf705eeb754_large/elderly-memories-strength-stockcake.jpg" ));
        clientes.put(6, new Cliente(6, 374827345, "Luis", "Calle 2", "5555555", "https://images.stockcake.com/public/e/7/b/e7baaf7b-a4f4-4dd2-af9c-fdf60da52c8d_large/digital-data-reflection-stockcake.jpg"));
    }

    public Cliente findById(int id) {
        return clientes.get(id);
    }

    public Collection<Cliente> findAll() {
        return clientes.values();
    }

    //nuevos metodos
    public void deleteById(int id) {
        clientes.remove(id);

    }

    public void update(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    public void add(Cliente cliente) {
        int tam = clientes.size();
        int lastId = clientes.get(tam).getId();
        cliente.setId(lastId + 1);
        clientes.put(cliente.getId(), cliente);
    }

}
