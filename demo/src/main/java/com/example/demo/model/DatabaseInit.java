package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.demo.repository.AdministradorRepository;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.DrogaRepository;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.TratamientoRepository;
import com.example.demo.repository.VeterinarioRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner{

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    MascotaRepository mascotaRepository;


    @Autowired
    VeterinarioRepository veterinarioRepository;

    @Autowired
    AdministradorRepository administradorRepository;

    @Autowired
    DrogaRepository drogaRepository;

    
    @Autowired
    TratamientoRepository tratamientoRepository;


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
        
       // Agregar mascotas a la base de datos
mascotaRepository.save(new Mascota("Misu", "Persa", 3, 4.2f, "Asma", "https://static.nationalgeographicla.com/files/styles/image_3200/public/nationalgeographic_1468962.jpg?w=1900&h=1400"));
mascotaRepository.save(new Mascota("Gatito", "Siamés", 2, 3.8f, "Alergia", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7Rsfl6dIGPbojoNrUPdja0WjgGk8ESACRZg&s"));
mascotaRepository.save(new Mascota("Nube", "Maine Coon", 4, 5.5f, "Obesidad", "https://static.nationalgeographic.es/files/styles/image_3200/public/75552.ngsversion.1422285553360.jpg?w=1900&h=1267"));
mascotaRepository.save(new Mascota("Luna", "Bengala", 1, 3.0f, "Conjuntivitis", "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/GettyImages-623368750-e1582816063521-1.jpg"));
mascotaRepository.save(new Mascota("Felix", "Británico de pelo corto", 5, 4.8f, "Artritis", "https://www.mirringo.com.co/Portals/mirringo/Images/articulos-actualidad-gatuna/ciclo-de-vida-de-los-gatos/Interna-1-ciclo-de-vida-de-los-gatos.jpg?ver=2024-03-20-160432-910"));
mascotaRepository.save(new Mascota("Salem", "Esfinge", 2, 3.5f, "Dermatitis", "https://urgenciesveterinaries.com/wp-content/uploads/2023/09/survet-gato-caida-pelo-01.jpeg"));
mascotaRepository.save(new Mascota("Tom", "Azul ruso", 4, 4.3f, "Problemas dentales", "https://images.ctfassets.net/denf86kkcx7r/4IPlg4Qazd4sFRuCUHIJ1T/f6c71da7eec727babcd554d843a528b8/gatocomuneuropeo-97"));
mascotaRepository.save(new Mascota("Milo", "Chartreux", 3, 3.9f, "Infección urinaria", "https://static.nationalgeographic.es/files/styles/image_3200/public/01-cat-groom-nationalgeographic-1031934.jpg?w=1600"));
mascotaRepository.save(new Mascota("Simba", "Abisinio", 2, 4.0f, "Inmunodeficiencia felina", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFfYvvtpTzrBYEKzjEzJH8lWbS1ab2pjeiAA&s"));
mascotaRepository.save(new Mascota("Coco", "Ragdoll", 1, 4.5f, "Parásitos", "https://greentology.life/wp-content/uploads/2023/11/gatos_adorable-gatito-gafas-sol.jpg"));
mascotaRepository.save(new Mascota("Oreo", "Gato doméstico", 2, 4.0f, "Obesidad", "https://fotografias.lasexta.com/clipping/cmsimages02/2019/01/25/DB41B993-B4C4-4E95-8B01-C445B8544E8E/98.jpg?crop=4156,2338,x0,y219&width=1900&height=1069&optimize=high&format=webply"));
mascotaRepository.save(new Mascota("Mittens", "Siberiano", 3, 5.0f, "Infección respiratoria", "https://upload.wikimedia.org/wikipedia/commons/4/46/Zuri.jpg"));
mascotaRepository.save(new Mascota("Pinky", "Himalayo", 4, 4.6f, "Problemas de piel", "https://www.zooplus.es/magazine/wp-content/uploads/2022/01/Psicologia-felina.jpeg"));
mascotaRepository.save(new Mascota("Oscar", "Norwegian Forest", 5, 5.2f, "Diarrea", "https://media.es.wired.com/photos/657cb5b81e17b099f8f9e15c/16:9/w_3008,h_1692,c_limit/gatos%20172050389.jpg"));
mascotaRepository.save(new Mascota("Bella", "Abisinio", 1, 3.4f, "Inmunodeficiencia felina", "https://www.clinicaveterinariazarpa.com/wp-content/uploads/2024/01/zarpa-blog.jpg"));
mascotaRepository.save(new Mascota("Cleo", "Bengala", 2, 4.1f, "Alergia alimentaria", "https://static.nationalgeographicla.com/files/styles/image_3200/public/01-cat-questions-nationalgeographic_1228126.jpg?w=1600&h=900"));
mascotaRepository.save(new Mascota("Max", "Británico de pelo corto", 3, 4.0f, "Problemas cardíacos", "https://purina.com.co/sites/default/files/styles/webp/public/2022-10/purina-10-datos-curiosos-sobre-los-gatos.png.webp?itok=3B4Lm7-f"));
mascotaRepository.save(new Mascota("Lily", "Siamés", 2, 3.8f, "Alergia", "https://www.hola.com/horizon/square/ee725cadf31b-gatos-caseros-t.jpg"));
mascotaRepository.save(new Mascota("Nina", "Gato de pelo largo", 1, 4.3f, "Parásitos", "https://www.ngenespanol.com/wp-content/uploads/2024/02/estas-son-las-razas-de-gatos-que-viven-mas-1280x720.jpg"));
mascotaRepository.save(new Mascota("Maggie", "Sphynx", 3, 4.0f, "Dermatitis", "https://s1.elespanol.com/2023/03/10/curiosidades/mascotas/747436034_231551833_854x640.jpg"));
mascotaRepository.save(new Mascota("Toby", "Manx", 4, 5.1f, "Problemas digestivos", "https://cdn.royalcanin-weshare-online.io/GlbQCHwBBKJuub5qnL9Z/v5/bp-lot-3-american-bobtail-davinci"));
mascotaRepository.save(new Mascota("Zara", "Scottish Fold", 5, 4.7f, "Diarrea", "https://www.whiskas.cl/cdn-cgi/image/height=617,f=auto,quality=90/sites/g/files/fnmzdf4541/files/2023-11/elever-un-Chaton-ses-premiers-mois.jpg"));
mascotaRepository.save(new Mascota("Buddy", "Cornish Rex", 2, 3.9f, "Problemas respiratorios", "https://www.marthadebayle.com/wp-content/uploads/2023/06/de-donde-vienen-los-gatos.jpg"));
mascotaRepository.save(new Mascota("Misty", "Burmese", 3, 4.4f, "Problemas dentales", "https://s1.ppllstatics.com/lasprovincias/www/multimedia/202112/12/media/cortadas/gatos-kb2-U160232243326NVC-1248x770@Las%20Provincias.jpg"));
mascotaRepository.save(new Mascota("Paws", "Oriental", 4, 3.8f, "Enfermedad hepática", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/220px-Cat_November_2010-1a.jpg"));
mascotaRepository.save(new Mascota("Whiskers", "Singapura", 1, 4.0f, "Obesidad", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSA0sgWEbLlrrbm2qrM7I4xbHo2LGMnMuUIvQ&s"));
mascotaRepository.save(new Mascota("Charlie", "Selkirk Rex", 2, 3.7f, "Alergia", "https://www.elespectador.com/resizer/GtLezpDdZTdlwNqHVM1C0zSafJw=/arc-anglerfish-arc2-prod-elespectador/public/BOP5BVFGYBDMDK4J5B7YQ3VOUM.jpg"));
mascotaRepository.save(new Mascota("Sasha", "Turco Van", 3, 4.2f, "Problemas digestivos", "https://www.veterinariaargosalbacete.com/wp-content/uploads/2020/12/mi-gato-pierde-mucho-pelo.jpg"));
mascotaRepository.save(new Mascota("Oliver", "Ragdoll", 4, 4.5f, "Parásitos", "https://img2.rtve.es/i/?w=1600&i=1618587961630.jpg"));
mascotaRepository.save(new Mascota("Luna", "Somalí", 5, 5.0f, "Problemas respiratorios", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgWOCLVV0wRNYlUPGDb-3RZto74mTVl55NMA&s"));
mascotaRepository.save(new Mascota("Daisy", "Maine Coon", 1, 5.3f, "Obesidad", "https://puppis.blog/wp-content/uploads/2022/02/abc-cuidado-de-los-gatos-min.jpg"));
mascotaRepository.save(new Mascota("Simba", "Bengala", 2, 4.2f, "Inmunodeficiencia felina", "https://cdn.prod.website-files.com/63634f4a7b868a399577cf37/63e10bf28752f848463155b3_razas%20de%20gatos.jpg"));
mascotaRepository.save(new Mascota("Lola", "Bengala", 3, 4.1f, "Problemas dentales", "https://ichef.bbci.co.uk/ace/ws/640/cpsprodpb/10E9B/production/_109757296_gettyimages-1128004359.jpg.webp"));
mascotaRepository.save(new Mascota("Leo", "Siamés", 4, 3.8f, "Problemas de piel", "https://estaticos-cdn.prensaiberica.es/clip/4e1211c1-1520-41a7-aabb-42c2e03d1731_alta-libre-aspect-ratio_default_0.jpg"));
mascotaRepository.save(new Mascota("Kiki", "Siamés", 5, 3.9f, "Alergia alimentaria", "https://okdiario.com/img/2021/04/20/curiosidades-sobre-los-gatos-domesticos-635x358.jpg"));
mascotaRepository.save(new Mascota("Trixie", "Británico de pelo corto", 1, 4.0f, "Artritis", "https://imagenes.eltiempo.com/files/image_1200_600/uploads/2023/03/13/640f76f75c8c7.jpeg"));
mascotaRepository.save(new Mascota("Fiona", "British Shorthair", 2, 4.2f, "Obesidad", "https://www.cadenadial.com/wp-content/uploads/2021/10/GettyImages-1302471279-1-1-scaled-e1649764781524.jpg"));
mascotaRepository.save(new Mascota("Tommy", "Maine Coon", 3, 5.5f, "Infección respiratoria", "https://parcerosfelinos.com/wp-content/uploads/2022/06/La-flexibilidad-y-agilidad-de-los-gatos-1024x576.jpg"));
mascotaRepository.save(new Mascota("Coco", "Maine Coon", 4, 5.4f, "Diarrea", "https://imagenes.20minutos.es/files/image_1920_1080/uploads/imagenes/2023/08/22/gato-esfinge-sphynx-dmitri-makeev-wikimedia-commons-cc-by-sa-4-0.jpeg"));
mascotaRepository.save(new Mascota("Lucy", "Turco Van", 5, 4.1f, "Alergia alimentaria", "https://www.ngenespanol.com/wp-content/uploads/2023/06/gatos-nariz-1280x720.jpeg"));
mascotaRepository.save(new Mascota("Rex", "Sphynx", 1, 3.7f, "Problemas respiratorios", "https://dovet.es/wp-content/uploads/2017/01/gato-768x658.jpg"));
mascotaRepository.save(new Mascota("Lilly", "Sphynx", 2, 3.9f, "Parásitos", "https://media.admagazine.com/photos/618a65c8e702c61c265bbcef/master/w_1600%2Cc_limit/73996.jpg"));
mascotaRepository.save(new Mascota("Charlie", "Scottish Fold", 3, 4.0f, "Problemas dentales", "https://static.fundacion-affinity.org/cdn/farfuture/46mZnLhAYw8xwZBGnHdtITnaZqhrx5cvHSN81eUMWzw/mtime:1528830293/sites/default/files/el-gato-necesita-tener-acceso-al-exterior.jpg"));
mascotaRepository.save(new Mascota("Milo", "Scottish Fold", 4, 3.8f, "Inmunodeficiencia felina", "https://clinicaveterinarium.es/wp-content/uploads/2023/11/lindo-gatito-gato-siames-interior.jpg"));
mascotaRepository.save(new Mascota("Toby", "Singapura", 5, 4.2f, "Enfermedad hepática", "https://www.zooplus.es/magazine/wp-content/uploads/2018/11/fotolia_122422577-768x576.jpg"));
mascotaRepository.save(new Mascota("Bella", "Singapura", 1, 4.3f, "Problemas digestivos", "https://cdn.nubika.es/wp-content/uploads/2023/11/12151442/manias-gatos.jpg"));
mascotaRepository.save(new Mascota("Paws", "Oriental", 2, 4.1f, "Problemas respiratorios", "https://s1.elespanol.com/2020/11/16/curiosidades/mascotas/mascotas-gatos-plantas_536457166_165216701_1706x960.jpg"));
mascotaRepository.save(new Mascota("Ginger", "Siamés", 3, 3.6f, "Alergia alimentaria", "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/el-celo-en-los-gatos-1.jpg?w=1024"));
mascotaRepository.save(new Mascota("Luna", "Siamés", 4, 3.8f, "Obesidad", "https://www.laalergia.com/sites/reactine_es/files/files/header-images/shutterstock_1007849866_1_gatos1.jpg"));
mascotaRepository.save(new Mascota("Whiskers", "Ragdoll", 5, 4.0f, "Alergia", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbAFikj08RaTh0rrq0bz38GGks5jimSJE5Qg&s"));
mascotaRepository.save(new Mascota("Luna", "Persa", 3, 4.0f, "Alergia", "https://imagenes.eltiempo.com/files/image_1200_600/uploads/2023/02/07/63e2e8ab9eda8.jpeg"));
mascotaRepository.save(new Mascota("Lola", "Siamés", 2, 3.5f, "Asma", "https://content.elmueble.com/medio/2023/04/14/gato-de-raza-ragdoll_5c5827ec_230414185205_1000x1493.jpg"));
mascotaRepository.save(new Mascota("Maggie", "Maine Coon", 4, 5.1f, "Conjuntivitis", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTB0c_EPB9CwcFXEDhfoe3gMcX2xawCOu1Hyw&s"));
mascotaRepository.save(new Mascota("Charlie", "Sphynx", 1, 4.2f, "Dermatitis", "https://t2.uc.ltmcdn.com/es/posts/8/4/6/cuales_son_los_gatos_mas_tranquilos_33648_600.webp"));
mascotaRepository.save(new Mascota("Felix", "Bengala", 5, 4.4f, "Infección respiratoria", "https://www.tiendanimal.es/articulos/wp-content/uploads/2018/01/mitos-sobre-gatos-1200x900.jpg"));
mascotaRepository.save(new Mascota("Oscar", "Scottish Fold", 3, 4.1f, "Problemas dentales", "https://imagenes.heraldo.es/files/image_1920_1080/uploads/imagenes/2024/01/26/gatito-gato-gsc1.jpeg"));
mascotaRepository.save(new Mascota("Ginger", "Siamés", 2, 3.7f, "Parásitos", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqd0wOkN4enR8kBYhBauFqJE-lWCfQxtULtw&s"));
mascotaRepository.save(new Mascota("Milo", "Maine Coon", 4, 5.3f, "Diarrea", "https://www.clarin.com/2012/02/04/BJbM2IRnQg_1200x0.jpg"));
mascotaRepository.save(new Mascota("Nina", "Bengala", 1, 4.0f, "Problemas digestivos", "https://e00-elmundo.uecdn.es/assets/multimedia/imagenes/2023/12/12/17023776436291.jpg"));
mascotaRepository.save(new Mascota("Sasha", "Sphynx", 3, 4.2f, "Problemas respiratorios", "https://ichef.bbci.co.uk/ace/ws/640/cpsprodpb/18504/production/_90488599_thinkstockphotos_gato6.jpg.webp"));
mascotaRepository.save(new Mascota("Luna", "Turco Van", 2, 4.5f, "Conjuntivitis", "https://cdn.royalcanin-weshare-online.io/fyI_PmYBaxEApS7LyAb0/v1/ec36h-is-your-cat-stressed-hero-cat"));
mascotaRepository.save(new Mascota("Bella", "Siamés", 4, 3.8f, "Artritis", "https://vitakraft.es/wp-content/uploads/2022/05/Blog_ColaGatos-1110x600.jpg"));
mascotaRepository.save(new Mascota("Simba", "Sphynx", 1, 3.9f, "Obesidad", "https://purina.com.uy/sites/default/files/styles/webp/public/2022-10/conoce-por-que-no-es-buena-idea-usar-un-disfraz-para-tu-gato-desktop.png.webp?itok=pa7TzVHV"));
mascotaRepository.save(new Mascota("Ginger", "Maine Coon", 2, 5.0f, "Problemas dentales", "https://www.elespectador.com/resizer/v2/LKMDZKHDHVE75GCRD5XPBUKHCY.png?auth=d67de540966cff25edba7ada9da45a77a1d027404c50f8ee20c387e5f1d8e441&width=920&height=613&smart=true&quality=60"));
mascotaRepository.save(new Mascota("Daisy", "Bengala", 3, 4.3f, "Alergia", "https://estaticos-cdn.prensaiberica.es/clip/132634e7-ba6a-4ea6-b531-f0377b7a9eba_alta-libre-aspect-ratio_default_0.jpg"));
mascotaRepository.save(new Mascota("Max", "Persa", 4, 4.1f, "Problemas digestivos", "https://images.ctfassets.net/ozvjkvyngwhv/7XI7Nz6LVrBPN8PqHFOGg/1837c9f22f7b95bc0001d4dec4d5b70e/1024-X-300-IMG-BLOG-CAIDA-DEL-PELO-DE-TU-PELUDO-__1_.jpg"));
mascotaRepository.save(new Mascota("Cleo", "Scottish Fold", 2, 4.2f, "Infección respiratoria", "https://static.eldiario.es/clip/ab74aa95-3656-424c-8ca1-dce590aabb97_16-9-discover-aspect-ratio_default_0.jpg"));
mascotaRepository.save(new Mascota("Whiskers", "Sphynx", 5, 3.9f, "Problemas de piel", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTPlwn347GKEW5rFh5y34Ow_epRu4bqNXFTA&s"));
mascotaRepository.save(new Mascota("Lucy", "Maine Coon", 3, 5.4f, "Alergia alimentaria", "https://vitakraft.es/wp-content/uploads/2020/06/imagen_gato_cachorro_1920x1280-1110x600.jpg"));
mascotaRepository.save(new Mascota("Toby", "Bengala", 1, 4.0f, "Problemas respiratorios", "https://okdiario.com/img/2020/07/25/curiosidades-sobre-la-inteligencia-de-los-gatos-635x358.jpg"));
mascotaRepository.save(new Mascota("Coco", "Siamés", 2, 4.5f, "Artritis", "https://resizer.glanacion.com/resizer/v2/un-experto-recomendo-con-que-gatos-no-hay-que-4WWGJ4UZUNC6PIMTJ7UEII2WAA.jpg?auth=fe8ee5dd7cd5bbc7e39915c95ecfebae17d1e3305e95f232afeaea5dffc4b121&width=880&height=586&quality=70&smart=true"));
mascotaRepository.save(new Mascota("Paws", "Scottish Fold", 4, 3.7f, "Conjuntivitis", "https://www.aon.es/personales/seguro-perro-gato/wp-content/uploads/sites/2/2022/11/beautiful-cat-portrait-close-up-scaled.jpg"));
mascotaRepository.save(new Mascota("Oliver", "Sphynx", 3, 4.1f, "Problemas digestivos", "https://pymstatic.com/58113/conversions/rasgos-personalidad-de-gatos-wide_webp.webp"));
mascotaRepository.save(new Mascota("Lilly", "Maine Coon", 2, 5.0f, "Alergia", "https://www.abc.es/xlsemanal/wp-content/uploads/sites/5/2023/10/como-entender-gatos-animales.jpg"));
mascotaRepository.save(new Mascota("Trixie", "Siamés", 1, 3.8f, "Problemas dentales", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6M8la1eBKQsT5oTD813L68C313PFOuFLtjg&s"));
mascotaRepository.save(new Mascota("Rex", "Turco Van", 2, 4.3f, "Infección respiratoria", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNlmQqkTa7XWHHg8AWHHVxuM0fAMay5QRqCw&s"));
mascotaRepository.save(new Mascota("Zara", "Sphynx", 3, 4.2f, "Problemas de piel", "https://media.admagazine.com/photos/6272c673fa786b10d9e7780d/1:1/w_2000,h_2000,c_limit/Gato%20en%20mesa.jpg"));
mascotaRepository.save(new Mascota("Tommy", "Scottish Fold", 5, 4.4f, "Artritis", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR85NT0d9snLMWnuXMkyqLoZp1V-Fh-muhXUQ&s"));
mascotaRepository.save(new Mascota("Ginger", "Siamés", 1, 3.9f, "Diarrea", "https://images.ctfassets.net/denf86kkcx7r/7HUeRIOQ67bN5lIiOki9ak/080930351b7b94d4cef7ec73afff522d/ojosgato-29"));
mascotaRepository.save(new Mascota("Paws", "Bengala", 2, 4.1f, "Problemas digestivos", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpxwVkMp-Ywwaw_nHmZ0ECWQARUXfoyPydvw&s"));
mascotaRepository.save(new Mascota("Whiskers", "Persa", 3, 4.0f, "Inmunodeficiencia felina", "https://www.semana.com/resizer/v2/ZBGOE4OONZFWHCNBX62IC4XGYM.jpg?auth=239467349145c9956f034421e45259e12a778ffb204946658239289137f33bb6&smart=true&quality=75&width=1280&height=720"));
mascotaRepository.save(new Mascota("Lola", "Scottish Fold", 4, 4.2f, "Alergia alimentaria", "https://s3.abcstatics.com/abc/www/multimedia/sociedad/2024/07/11/gato-RaZLibek03KjY2lBzGD2qEN-1200x840@diario_abc.jpg"));
mascotaRepository.save(new Mascota("Milo", "Turco Van", 5, 4.3f, "Problemas respiratorios", "https://www.purina.es/sites/default/files/2021-12/Temperatura%20corporal%20de%20los%20gatos_teaser_0.jpg"));
mascotaRepository.save(new Mascota("Felix", "Maine Coon", 2, 5.2f, "Problemas dentales", "https://gatogazzu.org/wp-content/uploads/2022/08/abuelo-de-los-gatos-930x620.jpg"));
mascotaRepository.save(new Mascota("Maggie", "Siamés", 1, 3.6f, "Artritis", "https://paradispets.com/wp-content/uploads/2022/08/Gato_Bengali_Trepando_Arbol_Paradispets-600x450.jpg"));
mascotaRepository.save(new Mascota("Simba", "Sphynx", 4, 4.5f, "Problemas digestivos", "https://www.semana.com/resizer/v2/CIHCDVOZDVDZJH3WEEVHBWIEXQ.jpg?auth=4039191476d08871fb55ec848583ab79d116a195944ad9801fea1cd071463723&smart=true&quality=75&width=1280"));
mascotaRepository.save(new Mascota("Charlie", "Bengala", 3, 4.4f, "Infección respiratoria", "https://manchas.com/wp-content/uploads/2024/05/arena-gato.png"));
mascotaRepository.save(new Mascota("Luna", "Persa", 2, 4.1f, "Alergia alimentaria", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwVwucpWLWNs2HBkpY4BWvy91ruBJQt4UXLA&s"));
mascotaRepository.save(new Mascota("Nina", "Maine Coon", 5, 5.1f, "Problemas de piel", "https://hospitalveterinariodonostia.com/wp-content/uploads/2022/02/Personalidad-gatos-674x337.png"));
mascotaRepository.save(new Mascota("Oscar", "Scottish Fold", 4, 4.3f, "Conjuntivitis", "https://caracol.com.co/resizer/v2/D72LMWGUFBCGPCG3BBZWYYEJGQ.jpg?auth=552e83952f719f5644534af5b51938818611533417438a78db1b56a8af31a677&width=650&height=488&quality=70&smart=true"));
mascotaRepository.save(new Mascota("Whiskers", "Turco Van", 2, 4.2f, "Alergia", "https://hips.hearstapps.com/hmg-prod/images/gettyimages-1056403846-662750de6b3b0.jpg?crop=1xw:0.8404971085409253xh;center,top&resize=1200:*"));
mascotaRepository.save(new Mascota("Rex", "Siamés", 3, 4.1f, "Problemas respiratorios", "https://nupec.com/wp-content/uploads/2022/09/fluffy-red-cat-resting-in-bright-sunlight-2022-08-01-02-05-31-utc-min.jpg"));
mascotaRepository.save(new Mascota("Bella", "Sphynx", 4, 3.8f, "Problemas digestivos", "https://www.laclinicaveterinaria.com/wp-content/uploads/2023/09/Las-vibrisas-o-bigotes-de-los-gatos.webp"));
mascotaRepository.save(new Mascota("Cleo", "Bengala", 5, 4.4f, "Inmunodeficiencia felina", "https://www.tiendanimal.es/articulos/wp-content/uploads/2022/03/Gato-Singapura-1200x900.jpg"));
mascotaRepository.save(new Mascota("Tommy", "Persa", 3, 4.0f, "Alergia alimentaria", "https://cnnespanol.cnn.com/wp-content/uploads/2024/07/estereotipo-mujeres-gato-e1722197008180.webp?w=414&h=311&crop=1"));
mascotaRepository.save(new Mascota("Ginger", "Maine Coon", 2, 5.0f, "Problemas respiratorios", "https://phantom-expansion.unidadeditorial.es/2f87033555d26483c0dc80c06caf5e48/resize/640/assets/multimedia/imagenes/2021/03/23/16164882584432.jpg"));
mascotaRepository.save(new Mascota("Simba", "Siamés", 1, 3.6f, "Artritis", "https://urgenciesveterinaries.com/wp-content/uploads/2024/03/survet-toxoplasmosis-01.jpg"));
mascotaRepository.save(new Mascota("Maggie", "Turco Van", 4, 4.3f, "Diarrea", "https://www.tugatobengali.com/wp-content/uploads/2022/04/exoticopelocorto-1.jpg"));
mascotaRepository.save(new Mascota("Oscar", "Bengala", 3, 4.0f, "Problemas digestivos", "https://www.clinicanimal.vet/wp-content/uploads/2023/07/acariciando-gato.jpg"));
mascotaRepository.save(new Mascota("Lilly", "Sphynx", 2, 3.8f, "Inmunodeficiencia felina", "https://imagenes.muyinteresante.com/files/article_social_75/uploads/2022/10/12/6346a7d3ec310.jpeg"));
mascotaRepository.save(new Mascota("Paws", "Persa", 4, 4.1f, "Problemas dentales", "https://blog.laika.com.co/wp-content/uploads/2022/04/kabo-p6yH8VmGqxo-unsplash.jpg"));




         // Agregar drogas a la base de datos
         drogaRepository.save(new Droga("Ibuprofeno", 10.0f, 15.0f, 100, "pastillas"));
         drogaRepository.save(new Droga("Paracetamol", 5.0f, 8.0f, 200, "pastillas"));
         drogaRepository.save(new Droga("Amoxicilina", 12.0f, 18.0f, 150, "capsulas"));
 
 
         // Agregar veterinarios a la base de datos
         veterinarioRepository.save(new Veterinario("2222", "Dr. Juan Pérez", "Medicina General", "juan.perez@mail.com", "0001"));
         veterinarioRepository.save(new Veterinario("3333", "Dra. Ana López", "Cirugía", "ana.lopez@mail.com", "0002"));
         veterinarioRepository.save(new Veterinario("5555", "Dr. Carlos Fernández", "Dermatología", "carlos.fernandez@mail.com", "0003"));

       
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
        
        
       // Asignar tratamiento

     // Define los IDs
List<Long> mascotaIds = Arrays.asList(1L, 2L, 3L); // Cambia estos IDs por los reales
List<Long> veterinarioIds = Arrays.asList(1L, 2L, 3L); // Cambia estos IDs por los reales
List<Long> drogaIds = Arrays.asList(1L, 2L, 3L); // Cambia estos IDs por los reales

// Crea un tratamiento para cada combinación de mascota, veterinario y droga
for (Long mascotaId : mascotaIds) {
    for (Long veterinarioId : veterinarioIds) {
        for (Long drogaId : drogaIds) {
            // Obtener las entidades
            Mascota mascota = mascotaRepository.findById(mascotaId).orElse(null);
            Veterinario veterinario = veterinarioRepository.findById(veterinarioId).orElse(null);
            Droga droga = drogaRepository.findById(drogaId).orElse(null);

            // Crear y guardar el tratamiento si todas las entidades existen
            if (mascota != null && veterinario != null && droga != null) {
                Tratamiento tratamiento = new Tratamiento(
                    "Tratamiento de " + droga.getNombre(),
                    LocalDate.now(),
                    mascota,
                    veterinario,
                    droga
                );

                tratamientoRepository.save(tratamiento);
            } else {
                System.out.println("No se pudo encontrar alguna de las entidades necesarias para la combinación: "
                        + "Mascota ID " + mascotaId + ", Veterinario ID " + veterinarioId + ", Droga ID " + drogaId);
            }
        }
    }
}

    }
}
