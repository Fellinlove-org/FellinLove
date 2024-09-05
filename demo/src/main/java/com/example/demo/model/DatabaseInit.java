package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import java.util.Optional;

import com.example.demo.repository.AdministradorRepository;
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

    @Autowired
    AdministradorRepository administradorRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        administradorRepository.save(new Administrador("123456", "Daniel Teran", "daniel_teran@example.com", "0000"));

        //Agregar clientes a la base de datos

        clienteRepository.save(new Cliente("001", "Ana Gómez", "ana.gomez@example.com", "3000000001", "https://randomuser.me/api/portraits/women/1.jpg"));
        clienteRepository.save(new Cliente("002", "Pedro Martínez", "pedro.martinez@example.com", "3000000002", "https://randomuser.me/api/portraits/men/1.jpg"));
        clienteRepository.save(new Cliente("003", "Laura Fernández", "laura.fernandez@example.com", "3000000003", "https://randomuser.me/api/portraits/women/2.jpg"));
        clienteRepository.save(new Cliente("004", "José Rodríguez", "jose.rodriguez@example.com", "3000000004", "https://randomuser.me/api/portraits/men/2.jpg"));
        clienteRepository.save(new Cliente("005", "Isabel Sánchez", "isabel.sanchez@example.com", "3000000005", "https://randomuser.me/api/portraits/women/3.jpg"));
        clienteRepository.save(new Cliente("006", "Luis Pérez", "luis.perez@example.com", "3000000006", "https://randomuser.me/api/portraits/men/3.jpg"));
        clienteRepository.save(new Cliente("007", "Sofia Torres", "sofia.torres@example.com", "3000000007", "https://randomuser.me/api/portraits/women/4.jpg"));
        clienteRepository.save(new Cliente("008", "Antonio López", "antonio.lopez@example.com", "3000000008", "https://randomuser.me/api/portraits/men/4.jpg"));
        clienteRepository.save(new Cliente("009", "Carla Martínez", "carla.martinez@example.com", "3000000009", "https://randomuser.me/api/portraits/women/5.jpg"));
        clienteRepository.save(new Cliente("010", "Francisco Gómez", "francisco.gomez@example.com", "3000000010", "https://randomuser.me/api/portraits/men/5.jpg"));
        clienteRepository.save(new Cliente("011", "Raquel González", "raquel.gonzalez@example.com", "3000000011", "https://randomuser.me/api/portraits/women/6.jpg"));
        clienteRepository.save(new Cliente("012", "Javier Fernández", "javier.fernandez@example.com", "3000000012", "https://randomuser.me/api/portraits/men/6.jpg"));
        clienteRepository.save(new Cliente("013", "Marta Pérez", "marta.perez@example.com", "3000000013", "https://randomuser.me/api/portraits/women/7.jpg"));
        clienteRepository.save(new Cliente("014", "Manuel Díaz", "manuel.diaz@example.com", "3000000014", "https://randomuser.me/api/portraits/men/7.jpg"));
        clienteRepository.save(new Cliente("015", "Carmen López", "carmen.lopez@example.com", "3000000015", "https://randomuser.me/api/portraits/women/8.jpg"));
        clienteRepository.save(new Cliente("016", "Carlos Morales", "carlos.morales@example.com", "3000000016", "https://randomuser.me/api/portraits/men/8.jpg"));
        clienteRepository.save(new Cliente("017", "Beatriz Martínez", "beatriz.martinez@example.com", "3000000017", "https://randomuser.me/api/portraits/women/9.jpg"));
        clienteRepository.save(new Cliente("018", "Fernando Romero", "fernando.romero@example.com", "3000000018", "https://randomuser.me/api/portraits/men/9.jpg"));
        clienteRepository.save(new Cliente("019", "Elena Rodríguez", "elena.rodriguez@example.com", "3000000019", "https://randomuser.me/api/portraits/women/10.jpg"));
        clienteRepository.save(new Cliente("020", "Sergio García", "sergio.garcia@example.com", "3000000020", "https://randomuser.me/api/portraits/men/10.jpg"));
        clienteRepository.save(new Cliente("021", "Gabriela Fernández", "gabriela.fernandez@example.com", "3000000021", "https://randomuser.me/api/portraits/women/11.jpg"));
        clienteRepository.save(new Cliente("022", "David Fernández", "david.fernandez@example.com", "3000000022", "https://randomuser.me/api/portraits/men/11.jpg"));
        clienteRepository.save(new Cliente("023", "Victoria Pérez", "victoria.perez@example.com", "3000000023", "https://randomuser.me/api/portraits/women/12.jpg"));
        clienteRepository.save(new Cliente("024", "Miguel Álvarez", "miguel.alvarez@example.com", "3000000024", "https://randomuser.me/api/portraits/men/12.jpg"));
        clienteRepository.save(new Cliente("025", "Luz García", "luz.garcia@example.com", "3000000025", "https://randomuser.me/api/portraits/women/13.jpg"));
        clienteRepository.save(new Cliente("026", "José Sánchez", "jose.sanchez@example.com", "3000000026", "https://randomuser.me/api/portraits/men/13.jpg"));
        clienteRepository.save(new Cliente("027", "Valeria Ruiz", "valeria.ruiz@example.com", "3000000027", "https://randomuser.me/api/portraits/women/14.jpg"));
        clienteRepository.save(new Cliente("028", "Arturo Pérez", "arturo.perez@example.com", "3000000028", "https://randomuser.me/api/portraits/men/14.jpg"));
        clienteRepository.save(new Cliente("029", "Teresa López", "teresa.lopez@example.com", "3000000029", "https://randomuser.me/api/portraits/women/15.jpg"));
        clienteRepository.save(new Cliente("030", "Andrés Gómez", "andres.gomez@example.com", "3000000030", "https://randomuser.me/api/portraits/men/15.jpg"));
        clienteRepository.save(new Cliente("031", "Paola Ramírez", "paola.ramirez@example.com", "3000000031", "https://randomuser.me/api/portraits/women/16.jpg"));
        clienteRepository.save(new Cliente("032", "Felipe Jiménez", "felipe.jimenez@example.com", "3000000032", "https://randomuser.me/api/portraits/men/16.jpg"));
        clienteRepository.save(new Cliente("033", "Nancy Torres", "nancy.torres@example.com", "3000000033", "https://randomuser.me/api/portraits/women/17.jpg"));
        clienteRepository.save(new Cliente("034", "Héctor González", "hector.gonzalez@example.com", "3000000034", "https://randomuser.me/api/portraits/men/17.jpg"));
        clienteRepository.save(new Cliente("035", "Sandra Gómez", "sandra.gomez@example.com", "3000000035", "https://randomuser.me/api/portraits/women/18.jpg"));
        clienteRepository.save(new Cliente("036", "Luis Hernández", "luis.hernandez@example.com", "3000000036", "https://randomuser.me/api/portraits/men/18.jpg"));
        clienteRepository.save(new Cliente("037", "Monica López", "monica.lopez@example.com", "3000000037", "https://randomuser.me/api/portraits/women/19.jpg"));
        clienteRepository.save(new Cliente("038", "Ricardo Martínez", "ricardo.martinez@example.com", "3000000038", "https://randomuser.me/api/portraits/men/19.jpg"));
        clienteRepository.save(new Cliente("039", "María González", "maria.gonzalez@example.com", "3000000039", "https://randomuser.me/api/portraits/women/20.jpg"));
        clienteRepository.save(new Cliente("040", "Carlos Ramírez", "carlos.ramirez@example.com", "3000000040", "https://randomuser.me/api/portraits/men/20.jpg"));
        clienteRepository.save(new Cliente("041", "Lucía García", "lucia.garcia@example.com", "3000000041", "https://randomuser.me/api/portraits/women/21.jpg"));
        clienteRepository.save(new Cliente("042", "Santiago Torres", "santiago.torres@example.com", "3000000042", "https://randomuser.me/api/portraits/men/21.jpg"));
        clienteRepository.save(new Cliente("043", "Catalina Álvarez", "catalina.alvarez@example.com", "3000000043", "https://randomuser.me/api/portraits/women/22.jpg"));
        clienteRepository.save(new Cliente("044", "Guillermo Pérez", "guillermo.perez@example.com", "3000000044", "https://randomuser.me/api/portraits/men/22.jpg"));
        clienteRepository.save(new Cliente("045", "Daniela Mendoza", "daniela.mendoza@example.com", "3000000045", "https://randomuser.me/api/portraits/women/23.jpg"));
        clienteRepository.save(new Cliente("046", "Julio Gómez", "julio.gomez@example.com", "3000000046", "https://randomuser.me/api/portraits/men/23.jpg"));
        clienteRepository.save(new Cliente("047", "Sara Rodríguez", "sara.rodriguez@example.com", "3000000047", "https://randomuser.me/api/portraits/women/24.jpg"));
        clienteRepository.save(new Cliente("048", "Alfredo Jiménez", "alfredo.jimenez@example.com", "3000000048", "https://randomuser.me/api/portraits/men/24.jpg"));
        clienteRepository.save(new Cliente("049", "Juliana Moreno", "juliana.moreno@example.com", "3000000049", "https://randomuser.me/api/portraits/women/25.jpg"));
        clienteRepository.save(new Cliente("050", "Samuel Hernández", "samuel.hernandez@example.com", "3000000050", "https://randomuser.me/api/portraits/men/25.jpg"));
        

        // Agregar mascotas a la base de datos
        
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
        mascotaRepository.save(new Mascota("Oreo", "Gato doméstico", 2, 4.0f, "Obesidad", "https://www.pets4homes.co.uk/images/articles/5962/large/13-different-types-of-domestic-cats.jpg"));
        mascotaRepository.save(new Mascota("Mittens", "Siberiano", 3, 5.0f, "Infección respiratoria", "https://www.cats.org.uk/uploads/images/featurebox/hero-image-1600x900.jpg"));
        mascotaRepository.save(new Mascota("Pinky", "Himalayo", 4, 4.6f, "Problemas de piel", "https://www.thecatsite.com/community/attachments/4-jpg.413867/"));
        mascotaRepository.save(new Mascota("Oscar", "Norwegian Forest", 5, 5.2f, "Diarrea", "https://www.catster.com/wp-content/uploads/2019/06/close-up-of-a-Norwegian-Forest-cat.jpg"));
        mascotaRepository.save(new Mascota("Bella", "Abisinio", 1, 3.4f, "Inmunodeficiencia felina", "https://www.animalplanet.com.au/wp-content/uploads/2022/01/Abysinnian-Profile.jpg"));
        mascotaRepository.save(new Mascota("Cleo", "Bengala", 2, 4.1f, "Alergia alimentaria", "https://www.cattime.com/assets/uploads/2011/12/file_22903_bengal-cat.jpg"));
        mascotaRepository.save(new Mascota("Max", "Británico de pelo corto", 3, 4.0f, "Problemas cardíacos", "https://www.britishshorthair.ca/wp-content/uploads/2020/10/British-Shorthair-5.jpg"));
        mascotaRepository.save(new Mascota("Lily", "Siamés", 2, 3.8f, "Alergia", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Siamese_kitten.jpg/1200px-Siamese_kitten.jpg"));
        mascotaRepository.save(new Mascota("Nina", "Gato de pelo largo", 1, 4.3f, "Parásitos", "https://www.vetstreet.com/images/article/606x337/Long-Haired-Cat-Breed.jpg"));
        mascotaRepository.save(new Mascota("Maggie", "Sphynx", 3, 4.0f, "Dermatitis", "https://cdn2.thecatapi.com/images/Sy5u7l9VX.jpg"));
        mascotaRepository.save(new Mascota("Toby", "Manx", 4, 5.1f, "Problemas digestivos", "https://www.lovemeow.com/assets/imgs/8/0/0/800.jpg"));
        mascotaRepository.save(new Mascota("Zara", "Scottish Fold", 5, 4.7f, "Diarrea", "https://cdn2.thecatapi.com/images/62c5N5cV7.jpg"));
        mascotaRepository.save(new Mascota("Buddy", "Cornish Rex", 2, 3.9f, "Problemas respiratorios", "https://upload.wikimedia.org/wikipedia/commons/7/74/Cornish_Rex_cat_in_Stuttgart.jpg"));
        mascotaRepository.save(new Mascota("Misty", "Burmese", 3, 4.4f, "Problemas dentales", "https://www.thecatsite.com/community/attachments/burmese-1-jpg.410185/"));
        mascotaRepository.save(new Mascota("Paws", "Oriental", 4, 3.8f, "Enfermedad hepática", "https://cdn2.thecatapi.com/images/4t4dgv5Nm.jpg"));
        mascotaRepository.save(new Mascota("Whiskers", "Singapura", 1, 4.0f, "Obesidad", "https://cdn2.thecatapi.com/images/S1K6f5cV7.jpg"));
        mascotaRepository.save(new Mascota("Charlie", "Selkirk Rex", 2, 3.7f, "Alergia", "https://upload.wikimedia.org/wikipedia/commons/7/7a/Selkirk_Rex.jpg"));
        mascotaRepository.save(new Mascota("Sasha", "Turco Van", 3, 4.2f, "Problemas digestivos", "https://cdn2.thecatapi.com/images/Syx1x5c47.jpg"));
        mascotaRepository.save(new Mascota("Oliver", "Ragdoll", 4, 4.5f, "Parásitos", "https://cdn2.thecatapi.com/images/SJ_2V5R5E.jpg"));
        mascotaRepository.save(new Mascota("Luna", "Somalí", 5, 5.0f, "Problemas respiratorios", "https://cdn2.thecatapi.com/images/B1v2A5c5V.jpg"));
        mascotaRepository.save(new Mascota("Daisy", "Maine Coon", 1, 5.3f, "Obesidad", "https://cdn2.thecatapi.com/images/H1vZp5c5m.jpg"));
        mascotaRepository.save(new Mascota("Jasper", "Gato doméstico de pelo corto", 2, 4.0f, "Dermatitis", "https://cdn2.thecatapi.com/images/BJ4f5l9N7.jpg"));
        mascotaRepository.save(new Mascota("Lola", "American Shorthair", 3, 3.9f, "Infección respiratoria", "https://cdn2.thecatapi.com/images/rJ8F6l54m.jpg"));
        mascotaRepository.save(new Mascota("Tina", "Balinese", 4, 4.1f, "Problemas dentales", "https://cdn2.thecatapi.com/images/Sy5f5l5pm.jpg"));
        mascotaRepository.save(new Mascota("Rusty", "Bengala", 2, 4.2f, "Enfermedad hepática", "https://cdn2.thecatapi.com/images/SkXmj9r5z.jpg"));
        mascotaRepository.save(new Mascota("Nora", "Gato de pelo corto", 3, 3.7f, "Alergia", "https://cdn2.thecatapi.com/images/B1U5m5p9G.jpg"));
        mascotaRepository.save(new Mascota("Rex", "Gato de pelo largo", 4, 4.0f, "Infección urinaria", "https://cdn2.thecatapi.com/images/Bk5R6l5z.jpg"));
        mascotaRepository.save(new Mascota("Missy", "Gato Rex", 5, 4.5f, "Obesidad", "https://cdn2.thecatapi.com/images/BkX4X5cV7.jpg"));
        mascotaRepository.save(new Mascota("Bandit", "British Shorthair", 1, 4.3f, "Parásitos", "https://cdn2.thecatapi.com/images/B1mJ6l5Vm.jpg"));
        mascotaRepository.save(new Mascota("Peanut", "Siberiano", 2, 4.1f, "Dermatitis", "https://cdn2.thecatapi.com/images/BJ9qX9p9z.jpg"));
        mascotaRepository.save(new Mascota("Sammy", "Chartreux", 3, 5.0f, "Problemas cardíacos", "https://cdn2.thecatapi.com/images/S1Fz9r5p9.jpg"));
        mascotaRepository.save(new Mascota("Ginger", "Cornish Rex", 4, 4.2f, "Alergia", "https://cdn2.thecatapi.com/images/S1t7l5p9.jpg"));
        mascotaRepository.save(new Mascota("Loki", "Sphynx", 5, 4.0f, "Problemas dentales", "https://cdn2.thecatapi.com/images/Byu4X9l9V.jpg"));
        mascotaRepository.save(new Mascota("Oliver", "Russian Blue", 1, 5.0f, "Obesidad", "https://cdn2.thecatapi.com/images/HJ8fX5p5.jpg"));
        mascotaRepository.save(new Mascota("Oscar", "Egyptian Mau", 2, 4.1f, "Infección respiratoria", "https://cdn2.thecatapi.com/images/B1J7X9p5.jpg"));
        mascotaRepository.save(new Mascota("Sophie", "Turkish Angora", 3, 4.5f, "Problemas digestivos", "https://cdn2.thecatapi.com/images/By5f5X5V7.jpg"));
        mascotaRepository.save(new Mascota("Jasmine", "Himalayan", 4, 4.2f, "Parásitos", "https://cdn2.thecatapi.com/images/H1t4X5p5.jpg"));
        mascotaRepository.save(new Mascota("Max", "Munchkin", 5, 4.6f, "Problemas dentales", "https://cdn2.thecatapi.com/images/B1kJX5p5.jpg"));
        mascotaRepository.save(new Mascota("Roxy", "Gato doméstico", 1, 3.8f, "Alergia", "https://cdn2.thecatapi.com/images/Hk5qX5c5.jpg"));
        mascotaRepository.save(new Mascota("Toby", "American Curl", 2, 4.1f, "Infección urinaria", "https://cdn2.thecatapi.com/images/S1v7X5p9.jpg"));
        mascotaRepository.save(new Mascota("Lucy", "Manx", 3, 3.9f, "Problemas respiratorios", "https://cdn2.thecatapi.com/images/SkF4X9c5.jpg"));
        mascotaRepository.save(new Mascota("Bella", "Turkish Van", 4, 4.5f, "Diarrea", "https://cdn2.thecatapi.com/images/By8qX9p5.jpg"));
        mascotaRepository.save(new Mascota("Lola", "Siamés", 5, 4.0f, "Obesidad", "https://cdn2.thecatapi.com/images/B1X5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Mittens", "Burmese", 1, 4.2f, "Inmunodeficiencia felina", "https://cdn2.thecatapi.com/images/BkF5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Tina", "Selkirk Rex", 2, 4.3f, "Problemas digestivos", "https://cdn2.thecatapi.com/images/Sy8f5p9z.jpg"));
        mascotaRepository.save(new Mascota("Oscar", "Siberiano", 3, 4.4f, "Alergia", "https://cdn2.thecatapi.com/images/Sk5X5p5V.jpg"));
        mascotaRepository.save(new Mascota("Milo", "Bengala", 4, 4.2f, "Dermatitis", "https://cdn2.thecatapi.com/images/HJX5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Whiskers", "Oriental", 5, 4.0f, "Infección respiratoria", "https://cdn2.thecatapi.com/images/Sy5qX5p5.jpg"));
        mascotaRepository.save(new Mascota("Sasha", "Turco Angora", 1, 5.1f, "Problemas dentales", "https://cdn2.thecatapi.com/images/By8X5p9z.jpg"));
        mascotaRepository.save(new Mascota("Charlie", "Gato de pelo corto", 2, 4.3f, "Parásitos", "https://cdn2.thecatapi.com/images/HkF5X5c5.jpg"));
        mascotaRepository.save(new Mascota("Lucy", "Bengala", 3, 3.8f, "Problemas digestivos", "https://cdn2.thecatapi.com/images/S1F5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Maggie", "Chartreux", 4, 4.1f, "Obesidad", "https://cdn2.thecatapi.com/images/B1k8X5p5.jpg"));
        mascotaRepository.save(new Mascota("Paws", "Gato doméstico", 5, 3.9f, "Infección urinaria", "https://cdn2.thecatapi.com/images/B1X5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Oreo", "Siamés", 1, 4.0f, "Dermatitis", "https://cdn2.thecatapi.com/images/Sk5qX5p5.jpg"));
        mascotaRepository.save(new Mascota("Daisy", "Manx", 2, 4.2f, "Problemas respiratorios", "https://cdn2.thecatapi.com/images/B1v8X5p5.jpg"));
        mascotaRepository.save(new Mascota("Rusty", "Turkish Van", 3, 4.3f, "Inmunodeficiencia felina", "https://cdn2.thecatapi.com/images/Sy5qX5p5.jpg"));
        mascotaRepository.save(new Mascota("Jasper", "American Shorthair", 4, 4.1f, "Obesidad", "https://cdn2.thecatapi.com/images/S1k5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Nina", "Burmese", 5, 4.2f, "Alergia", "https://cdn2.thecatapi.com/images/By8X5p5z.jpg"));
        mascotaRepository.save(new Mascota("Toby", "Balinese", 1, 4.0f, "Parásitos", "https://cdn2.thecatapi.com/images/B1X5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Misty", "Sphynx", 2, 3.9f, "Diarrea", "https://cdn2.thecatapi.com/images/HJX5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Cleo", "Manx", 3, 4.4f, "Problemas dentales", "https://cdn2.thecatapi.com/images/S1X5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Bella", "Maine Coon", 4, 5.0f, "Problemas digestivos", "https://cdn2.thecatapi.com/images/Sk5X5p5p.jpg"));
        mascotaRepository.save(new Mascota("Oscar", "Siberiano", 5, 4.2f, "Infección respiratoria", "https://cdn2.thecatapi.com/images/HJX5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Whiskers", "Russian Blue", 1, 4.5f, "Parásitos", "https://cdn2.thecatapi.com/images/B1F5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Lola", "Bengala", 2, 4.1f, "Problemas dentales", "https://cdn2.thecatapi.com/images/Sk5X5p5V.jpg"));
        mascotaRepository.save(new Mascota("Sasha", "Himalayo", 3, 4.0f, "Alergia", "https://cdn2.thecatapi.com/images/B1X5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Jasper", "Turkish Angora", 4, 4.3f, "Obesidad", "https://cdn2.thecatapi.com/images/Bk5X5p5z.jpg"));
        mascotaRepository.save(new Mascota("Maggie", "Oriental", 5, 4.1f, "Infección urinaria", "https://cdn2.thecatapi.com/images/HJX5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Daisy", "Bengala", 1, 4.2f, "Problemas digestivos", "https://cdn2.thecatapi.com/images/S1X5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Cleo", "Sphynx", 2, 3.9f, "Parásitos", "https://cdn2.thecatapi.com/images/S1F5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Rusty", "Chartreux", 3, 4.1f, "Obesidad", "https://cdn2.thecatapi.com/images/Bk5X5p5z.jpg"));
        mascotaRepository.save(new Mascota("Luna", "Siamés", 4, 4.2f, "Alergia", "https://cdn2.thecatapi.com/images/HJX5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Oscar", "Manx", 5, 4.4f, "Infección respiratoria", "https://cdn2.thecatapi.com/images/S1X5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Jasper", "Burmese", 1, 4.5f, "Problemas dentales", "https://cdn2.thecatapi.com/images/B1F5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Daisy", "Maine Coon", 2, 4.6f, "Obesidad", "https://cdn2.thecatapi.com/images/Sk5X5p5p.jpg"));
        mascotaRepository.save(new Mascota("Maggie", "Bengala", 3, 4.0f, "Problemas digestivos", "https://cdn2.thecatapi.com/images/HJX5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Lola", "Turkish Van", 4, 4.2f, "Parásitos", "https://cdn2.thecatapi.com/images/S1X5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Sasha", "Oriental", 5, 4.3f, "Diarrea", "https://cdn2.thecatapi.com/images/B1X5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Rusty", "Sphynx", 1, 4.0f, "Infección urinaria", "https://cdn2.thecatapi.com/images/HJX5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Whiskers", "American Shorthair", 2, 4.5f, "Obesidad", "https://cdn2.thecatapi.com/images/S1X5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Luna", "Balinese", 3, 4.3f, "Alergia", "https://cdn2.thecatapi.com/images/S1F5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Maggie", "Bengala", 4, 4.1f, "Problemas digestivos", "https://cdn2.thecatapi.com/images/Sk5X5p5z.jpg"));
        mascotaRepository.save(new Mascota("Toby", "Siamés", 5, 4.2f, "Parásitos", "https://cdn2.thecatapi.com/images/S1X5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Misty", "Manx", 1, 4.3f, "Obesidad", "https://cdn2.thecatapi.com/images/S1F5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Cleo", "Maine Coon", 2, 4.6f, "Infección respiratoria", "https://cdn2.thecatapi.com/images/Sk5X5p5p.jpg"));
        mascotaRepository.save(new Mascota("Charlie", "Sphynx", 3, 4.0f, "Parásitos", "https://cdn2.thecatapi.com/images/HJX5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Oscar", "Burmese", 4, 4.5f, "Diarrea", "https://cdn2.thecatapi.com/images/S1X5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Sasha", "Oriental", 5, 4.2f, "Problemas dentales", "https://cdn2.thecatapi.com/images/Sk5X5p5z.jpg"));
        mascotaRepository.save(new Mascota("Nina", "Sphynx", 1, 4.0f, "Infección urinaria", "https://cdn2.thecatapi.com/images/S1X5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Misty", "Manx", 2, 4.5f, "Problemas digestivos", "https://cdn2.thecatapi.com/images/S1F5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Charlie", "Bengala", 3, 4.3f, "Obesidad", "https://cdn2.thecatapi.com/images/Sk5X5p5z.jpg"));
        mascotaRepository.save(new Mascota("Jasper", "Siamés", 4, 4.4f, "Parásitos", "https://cdn2.thecatapi.com/images/HJX5X5p5.jpg"));
        mascotaRepository.save(new Mascota("Bella", "Burmese", 5, 4.1f, "Problemas respiratorios", "https://cdn2.thecatapi.com/images/S1X5X5p5.jpg"));


        // Asociar mascotas con cliente
        Long clientId = 1L; // Inicializamos el ID del cliente.
        int mascotasPorCliente = 2; // Número de mascotas que asignaremos a cada cliente.
        int clienteMaxId = 50; // El ID máximo de cliente para el ciclo.

        int mascotaCounter = 0; // Contador de mascotas procesadas.

        for (Mascota m : mascotaRepository.findAll()) { // Iteramos sobre todas las mascotas obtenidas del repositorio.
            // Buscamos el cliente actual usando el ID.
            Optional<Cliente> optionalCliente = clienteRepository.findById(clientId);

            if (optionalCliente.isPresent()) { // Verificamos si el cliente con el ID 'clientId' existe.
                m.setCliente(optionalCliente.get()); // Asociamos la mascota al cliente encontrado.
                mascotaRepository.save(m); // Guardamos la mascota actualizada en el repositorio.
            } else {
                // Manejo del caso en que el cliente no existe.
                System.out.println("Cliente con ID " + clientId + " no encontrado.");
            }

            mascotaCounter++; // Incrementamos el contador de mascotas procesadas.

            // Cuando se asignan 2 mascotas a un cliente, cambiamos al siguiente cliente.
            if (mascotaCounter % mascotasPorCliente == 0) {
                clientId++; // Incrementamos el ID del cliente para la siguiente asignación.
                // Si hemos alcanzado el ID máximo de cliente, volvemos a empezar desde el cliente con ID 1.
                if (clientId > clienteMaxId) {
                    clientId = 1L;
                }
            }
        }       
    }
}
