package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.MascotaRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner{

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Agregar clientes a la base de datos
        clienteRepository.save(new Cliente(123456,"Daniel Teran","daniel@gmail.com","3214567890","https://coin-images.coingecko.com/coins/images/34755/large/IMG_0015.png?1705957165"));
        clienteRepository.save(new Cliente(112233, "Luis Fernández", "luis.fernandez@example.com", "1239874560", "https://coin-images.coingecko.com/coins/images/34755/large/IMG_0015.png?1705957165"));
        clienteRepository.save(new Cliente(445566, "Ana Martínez", "ana.martinez@example.com", "2345678901", "https://coin-images.coingecko.com/coins/images/34755/large/IMG_0015.png?1705957165"));
        clienteRepository.save(new Cliente(778899, "Carlos López", "carlos.lopez@example.com", "3456789012", "https://coin-images.coingecko.com/coins/images/34755/large/IMG_0015.png?1705957165"));
        clienteRepository.save(new Cliente(991122, "Sofía Ramírez", "sofia.ramirez@example.com", "4567890123", "https://coin-images.coingecko.com/coins/images/34755/large/IMG_0015.png?1705957165"));
        clienteRepository.save(new Cliente(334455, "Jorge Torres", "jorge.torres@example.com", "5678901234", "https://coin-images.coingecko.com/coins/images/34755/large/IMG_0015.png?1705957165"));
        clienteRepository.save(new Cliente(667788, "Elena Ruiz", "elena.ruiz@example.com", "6789012345", "https://coin-images.coingecko.com/coins/images/34755/large/IMG_0015.png?1705957165"));
        clienteRepository.save(new Cliente(992233, "Ricardo Morales", "ricardo.morales@example.com", "7890123456", "https://coin-images.coingecko.com/coins/images/34755/large/IMG_0015.png?1705957165"));
        clienteRepository.save(new Cliente(445577, "Gabriela Díaz", "gabriela.diaz@example.com", "8901234567", "https://coin-images.coingecko.com/coins/images/34755/large/IMG_0015.png?1705957165"));
        clienteRepository.save(new Cliente(778800, "Fernando Castro", "fernando.castro@example.com", "9012345678", "https://coin-images.coingecko.com/coins/images/34755/large/IMG_0015.png?1705957165"));
        clienteRepository.save(new Cliente(889911, "Laura Mendoza", "laura.mendoza@example.com", "0123456789", "https://coin-images.coingecko.com/coins/images/34755/large/IMG_0015.png?1705957165"));
    
        //agregar mascotas a la base de datos
        mascotaRepository.save(new Mascota("Misu", "Persa", 3, 4.2f, "Asma", "https://images.ctfassets.net/denf86kkcx7r/15HC92CcCjQEg7U14aZkVM/914db181ce7e407bc2a0220436a32aa4/un_gato_persa-39"));
        mascotaRepository.save(new Mascota("Gatito", "Siamés", 2, 3.8f, "Alergia", "https://i0.wp.com/imgs.hipertextual.com/wp-content/uploads/2021/04/siames-scaled.jpg?fit=2560%2C1707&quality=50&strip=all&ssl=1"));
        mascotaRepository.save(new Mascota("Nube", "Maine Coon", 4, 5.5f, "Obesidad", "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-06Maine-Coon-Cat.jpg?itok=6_sYilZv"));
        mascotaRepository.save(new Mascota("Luna", "Bengala", 1, 3.0f, "Conjuntivitis", "https://www.tiendanimal.es/articulos/wp-content/uploads/2020/04/gato-bengali-1200x900.jpg"));
        mascotaRepository.save(new Mascota("Felix", "Británico de pelo corto", 5, 4.8f, "Artritis", "https://nfnatcane.es/blog/wp-content/uploads/2020/07/British-shorthair.jpg"));
        mascotaRepository.save(new Mascota("Salem", "Esfinge", 2, 3.5f, "Dermatitis", "https://peru21-pe.b-cdn.net/sites/default/efsfiles/2024-03/NM4QZM4W3FEGZKUAKV3RFDHOVU.jpeg"));
        mascotaRepository.save(new Mascota("Tom", "Azul ruso", 4, 4.3f, "Problemas dentales", "https://t1.uc.ltmcdn.com/es/posts/7/0/2/como_es_el_gato_azul_ruso_22207_600.jpg"));
        mascotaRepository.save(new Mascota("Milo", "Chartreux", 3, 3.9f, "Infección urinaria", "https://imagenes.muyinteresante.com/files/article_social_75/uploads/2022/10/12/6346c7ff3ac74.jpeg"));
        mascotaRepository.save(new Mascota("Simba", "Abisinio", 2, 4.0f, "Inmunodeficiencia felina", "https://www.elmueble.com/medio/2023/03/30/gato-abisinio_94f72109_230330141505_900x900.jpg"));
        mascotaRepository.save(new Mascota("Coco", "Ragdoll", 1, 4.5f, "Parásitos", "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2021-01/Ragdoll.1.jpg?itok=LrGDnQWi"));


        //asociar mascotas con cliente
        
    }
    
}
