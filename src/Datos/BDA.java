/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Horario;
import Modelo.Incidencias;
import Modelo.Tienda;
import Modelo.Trabajador;
import java.sql.Connection;
import Modelo.Ruta;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import Modelo.Trabajador;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import javafx.scene.control.Alert;


/**
 *
 * @author Borja
 */
public class BDA {

    private Connection conn;
    List<Trabajador> listaTrabajadores = new ArrayList<>();
    public Connection conectar() throws SQLException {
        String bd = "comercio";
        String url = "jdbc:mysql://localhost:3306/" + bd;
        conn = DriverManager.getConnection(url, "root", "root");
        return conn;
        
    }
    public void desconectar() throws SQLException {
        conn.close();
    }

    
    

//    public List<Trabajador> consultar(String dni) throws SQLException {
//        List<Trabajador> lista = new ArrayList<>();
//        Trabajador t = null;
//        String consulta = "SELECT * FROM trabajadores";
//        PreparedStatement ps = conn.prepareCall(consulta);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            String dni1 = rs.getString("dniNie");
//            String nombre = rs.getString("contraseña");
//            t = new Trabajador(dni1, nombre);
//            lista.add(t);
//        }
//
//        return lista;
//    }

//    public void insertarRuta( Double kilometros, Integer minutos, Double gastos,String paradas) throws SQLException {
//        String consulta = "INSERT INTO rutas(kilometros,Minutos,Gastos,Paradas) values (?,?,?,?)";
//        PreparedStatement ps = conn.prepareStatement(consulta);
//        
//        ps.setDouble(1, kilometros);
//        ps.setInt(2, minutos);
//        ps.setDouble(3, gastos);
//        ps.setString(4, paradas);
//        ps.executeUpdate();
//
//    }

//    public List<Trabajador> listarTrabajadores() throws SQLException {
//        
//        String consulta = "SELECT * FROM trabajadores";
//        PreparedStatement ps = conn.prepareStatement(consulta, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            int id1 = rs.getInt("idTrabajador");
//            String nombre = rs.getNString("nombre");
//            String puesto = rs.getNString("puesto");
//            String dni = rs.getNString("dniNie");
//            Double salario = rs.getDouble("salario");
//            String contraseña = rs.getNString("contraseña");
//            int idTienda = rs.getInt("idTienda");
//            int idHorario = rs.getInt("idHorario");
//            int idRuta=rs.getInt("idRuta");
//            Trabajador t = new Trabajador(id1, nombre, puesto, dni, salario, contraseña, idTienda, idHorario, idRuta);
//            listaTrabajadores.add(t);
//        }
//        return listaTrabajadores;
//    }

//    public List<Incidencias> listarIncidencias() throws SQLException {
//        List<Incidencias> lista = new ArrayList<>();
//        PreparedStatement ps;
//        ResultSet rs;
//        String consulta;
//
//        conectar();
//        if (conn != null) {
//
//            consulta = "SELECT * FROM incidencias";
//            ps = conn.prepareStatement(consulta, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//
//                int idIncidencias = rs.getInt("idIncidencias");
//                String descripcion = rs.getString("Descripcion");
//                int idTrabajador = rs.getInt("idTrabajador");
//                int idTienda = rs.getInt("idTienda");
//                String fecha = rs.getString("fecha");
//
//                Incidencias incidencia = new Incidencias(idIncidencias, descripcion, idTrabajador, idTienda, fecha);
//                lista.add(incidencia);
//            }
//        }
//        return lista;
//    }

//    public int insertarIncidencia(int idTrabajador, int idTienda, String fecha, String descripcion) throws SQLException {
//        int numFilas;
//        String consulta = "INSERT INTO Incidencias(idTrabajador,idtienda,fecha ,descripcion) values (?,?,?,?)";
//        PreparedStatement ps = conn.prepareStatement(consulta);
//        
//        ps.setDouble(1, idTrabajador);
//        ps.setInt(2, idTienda);
//        ps.setString(3, fecha);
//        ps.setString(4, descripcion);
//        numFilas = ps.executeUpdate();
//        return numFilas;
//
//    }
//
//    public int borrarIncidencia(int idIncidencia) throws SQLException {
//        int numFilas;
//        String consulta = " DELETE FROM Incidencias WHERE idIncidencias = ?";
//        PreparedStatement ps = conn.prepareStatement(consulta);
//        ps.setInt(1, idIncidencia);
//
//        numFilas = ps.executeUpdate();
//        return numFilas;
//
//    }
//
//    public int cambiarIncidencia(int idIncidencias, int idTrabajador, int idTienda, String fecha, String descripcion) throws SQLException {
//        int numFilas;
//        String consulta = "UPDATE Incidencias SET descripcion=?,idTienda=?,idTrabajador=?,fecha=? WHERE idIncidencias =?";
//        PreparedStatement ps = conn.prepareStatement(consulta);
//        ps.setInt(5, idIncidencias);
//        ps.setInt(3, idTrabajador);
//        ps.setInt(2, idTienda);
//        ps.setString(1, descripcion);
//        ps.setString(4, fecha);
//
//        numFilas = ps.executeUpdate();
//        return numFilas;
//
//    }

//    public boolean consultarIDincidencia(int incidencia) throws SQLException {
//
//        boolean existe = false;
//
//        for (Incidencias velementos : listarIncidencias()) {
//
//            if (incidencia == velementos.getIdIncidencias()) {
//                existe = true;
//
//            }
//        }
//
//        return existe;
//    }

//    public boolean consultarIDhorario(int idHorario) throws SQLException {
//
//        boolean existe = false;
//
//        for (Horario velementos : listarHorarios()) {
//
//            if (idHorario == velementos.getIdHorarios()) {
//                existe = true;
//
//            }
//        }
//
//        return existe;
//    }
//
//    public ArrayList<Horario> listarHorarios() throws SQLException {
//        conectar();
//        int id;
//        String horaEntrada;
//        String horaSalida;
//        String fechaInicio;
//        String fechasalida;
//
//        ArrayList<Horario> listaHorarios = new ArrayList<>();
//        String consulta = "SELECT * FROM horarios";
//        PreparedStatement ps = conn.prepareStatement(consulta, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//        ResultSet rs = ps.executeQuery();
//
//        while (rs.next()) {
//            id = rs.getInt("idHorario");
//            horaEntrada = rs.getString("horaEntrada");
//            horaSalida = rs.getString("horaSalida");
//            fechaInicio = rs.getString("fechaInicio");
//            fechasalida = rs.getString("fechaFin");
//
//            Horario horarios = new Horario(id, horaEntrada, horaSalida, fechaInicio, fechasalida);
//            listaHorarios.add(horarios);
//        }
//        return listaHorarios;
//    }

//    public int insertarHorario( String horaEntrada, String horaSalida, String fechaInicio, String fechaFin) throws SQLException {
//        int numFilas;
//        String consulta = "INSERT INTO horarios(horaEntrada,horaSalida,fechaInicio,fechaFin) values (?,?,?,?)";
//        PreparedStatement ps = conn.prepareStatement(consulta);
//        
//        ps.setString(1, horaEntrada);
//        ps.setString(2, horaSalida);
//        ps.setString(3, fechaInicio);
//        ps.setString(4, fechaFin);
//        numFilas = ps.executeUpdate();
//        return numFilas;
//
//    }

//    public int cambiarHorario(int idHorario, String horaEntrada, String horaSalida, String fechaInicio, String fechaFin) throws SQLException {
//        int numFilas;
//        String consulta = "UPDATE horarios SET HoraEntrada=?,HoraSalida=?,fechaInicio=?,fechaFin=? WHERE idHorario = ?";
//        PreparedStatement ps = conn.prepareStatement(consulta);
//
//        ps.setString(1, horaEntrada);
//        ps.setString(2, horaSalida);
//        ps.setString(3, fechaInicio);
//        ps.setString(4, fechaFin);
//        ps.setInt(5, idHorario);
//
//        numFilas = ps.executeUpdate();
//        return numFilas;
//
//    }

//    public List<Tienda> listarTiendas() throws SQLException {
//        conectar();
//
//        List<Tienda> listaTiendas = new ArrayList<>();
//
//        String consulta = "SELECT * FROM tienda";
//        PreparedStatement ps = conn.prepareCall(consulta);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            int idTienda = rs.getInt("idTienda");
//            String pueblo = rs.getString("pueblo");
//            String direccion = rs.getString("direccion");
//            String telefono = rs.getString("telefono");
//            String codPostal = rs.getString("codPostal");
//
//            Tienda tienda = new Tienda(idTienda, pueblo, direccion, telefono, codPostal);
//            listaTiendas.add(tienda);
//        }
//        return listaTiendas;
//    }

//    public boolean consultarIDtienda(int idtienda) throws SQLException {
//
//        boolean existe = false;
//
//        for (Tienda velementos : listarTiendas()) {
//
//            if (idtienda == velementos.getIdTienda()) {
//                existe = true;
//
//            }
//        }
//
//        return existe;
//    }

//    public int insertarTienda(String pueblo, String direccion, String telefono, String codPostal) throws SQLException {
//        int numFilas;
//        String consulta = "INSERT INTO tienda(pueblo,direccion,telefono,codPostal) values (?,?,?,?)";
//        PreparedStatement ps = conn.prepareStatement(consulta);
//        
//        ps.setString(1, pueblo);
//        ps.setString(2, direccion);
//        ps.setString(3, telefono);
//        ps.setString(4, codPostal);
//        numFilas = ps.executeUpdate();
//        return numFilas;
//
//    }
//
//    public int cambiarTiendas(int idTienda, String pueblo, String direccion, String telefono, String codPostal) throws SQLException {
//        int numFilas;
//        String consulta = "UPDATE tienda SET pueblo=?,direccion=?,telefono=?,codPostal=? WHERE idTienda =?";
//        PreparedStatement ps = conn.prepareStatement(consulta);
//        ps.setString(1, pueblo);
//        ps.setString(2, direccion);
//        ps.setString(3, telefono);
//        ps.setString(4, codPostal);
//        ps.setInt(5, idTienda);
//
//        numFilas = ps.executeUpdate();
//        return numFilas;
//
//    }
//
//    public int borrarTienda(int idTienda) throws SQLException {
//        int numFilas;
//        String consulta = " DELETE FROM tienda WHERE idTienda = ?";
//        PreparedStatement ps = conn.prepareStatement(consulta);
//        ps.setInt(1, idTienda);
//
//        numFilas = ps.executeUpdate();
//        return numFilas;
//
//    }
//public List<Ruta> listarRutas() throws SQLException {
//        List<Ruta> listaRutas = new ArrayList<>();
//        String consulta = "SELECT * FROM rutas";
//        PreparedStatement ps = conn.prepareStatement(consulta);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            int id = rs.getInt("idRuta");
//            double kilometros = rs.getDouble("kilometros");
//            int minutos = rs.getInt("Minutos");
//            double gastos = rs.getDouble("Gastos");
//            String parada=rs.getString("Paradas");
//            Ruta r = new Ruta(id, kilometros, minutos, gastos,parada);
//            listaRutas.add(r);
//        }
//        return listaRutas;
//    }
//
//    public int borrarRuta(int id) throws SQLException {
//        Ruta r = null;
//        String consulta = "DELETE FROM rutas WHERE idRuta=?";
//        PreparedStatement ps = conn.prepareStatement(consulta);
//        ps.setInt(1, id);
//        int id1 = ps.executeUpdate();
//        return id1;
//    }
//
//    public int modificarRuta(Ruta r) throws SQLException {
//        String consulta = "UPDATE rutas set kilometros=?,Minutos=?,Gastos=?,Paradas=? where idRuta=?";
//        PreparedStatement ps = conn.prepareStatement(consulta);
//        ps.setDouble(1, r.getKilometros());
//        ps.setInt(2, r.getMinutos());
//        ps.setDouble(3, r.getGastos());
//        ps.setInt(4, r.getId());
//        ps.setString(5, r.getParadas());
//        int filas = ps.executeUpdate();
//        return filas;
//
//    }

//    public void insertarTrabajador(String nombre, String puesto, String dniNie, Double salario, String contraseña, int idTienda, int idHorario,int idRuta) throws SQLException {
//        String consulta = "INSERT INTO trabajadores (nombre, puesto, dniNie, salario, contraseña, idTienda, idHorario,idRuta, IRPF) VALUES (?,?,?,?,?,?,?,?,?)";
//        PreparedStatement ps = conn.prepareStatement(consulta);
//        
//        ps.setString(1, nombre);
//        ps.setString(2, puesto);
//        ps.setString(3, dniNie);
//        ps.setDouble(4, salario);
//        ps.setString(5, contraseña);
//        ps.setInt(6, idTienda);
//        ps.setInt(7, idHorario);
//        ps.setInt(8, idRuta);
//        ps.setDouble(9, 10);
//        ps.executeUpdate();
//
//    }

//    public int modificarTrabajador(Trabajador t) throws SQLException {
//        String consulta = "UPDATE trabajadores set nombre=?,puesto=?, dniNie=?,salario=?, contraseña=?, idTienda=?, idHorario=?, idRuta=? where idTrabajador=?";
//        PreparedStatement ps = conn.prepareStatement(consulta);
//        ps.setString(1, t.getNombre());
//        ps.setString(2, t.getPuesto());
//        ps.setString(3,t.getDNI());
//        ps.setDouble(4, t.getSalario());
//        ps.setString(5, t.getContraseña());
//        ps.setInt(6, t.getIdTienda());
//        ps.setInt(7, t.getIdHorario());
//        ps.setInt(8, t.getIdRuta());
//        ps.setInt(9, t.getIdTrabajador());
//        
//        int filas = ps.executeUpdate();
//        return filas;
//    }

//    public int borrarTrabajador(int id) throws SQLException {
//        Trabajador r = null;
//        String consulta = "DELETE FROM trabajadores WHERE idTrabajador=?";
//        PreparedStatement ps = conn.prepareStatement(consulta);
//        ps.setInt(1, id);
//        int id1 = ps.executeUpdate();
//        return id1;
//    }

//    public List<String> cargaPuesto(Path archivo) {
//
//        List<String> listaPuestos = new ArrayList<>();
//        String puesto;
//        String nPuesto;
//
//        try (Stream<String> datos = Files.lines(archivo)) {
//            Iterator<String> it = datos.iterator();
//            while (it.hasNext()) {
//                puesto = it.next();
//                String[] trozo = puesto.split(",");
//                nPuesto = trozo[0];
//                listaPuestos.add(nPuesto);
//            }
//
//        } catch (IOException ex) {
//
//        }
//        return listaPuestos;
//    }
//    public int borrarHorario(int idHorario) throws SQLException {
//        int numFilas = 0;
//
//        String consulta = " DELETE FROM horarios WHERE idHorario = ?";
//        PreparedStatement ps;
//        ps = conn.prepareStatement(consulta);
//        ps.setInt(1, idHorario);
//
//        numFilas = ps.executeUpdate();
//
//        return numFilas;
//
//    }
    
//    public String generarInformacion(File archivo) throws SQLException {
//        String devuelve = "";
//        try (BufferedWriter out = Files.newBufferedWriter(archivo.toPath(), StandardOpenOption.CREATE_NEW)) {
//            out.write("IDTRABAJADOR   NOMBRE   PASSWORD");
//            out.newLine();
//            for (int i = 0; i < listaTrabajadores.size(); i++) {
//                out.write(listaTrabajadores.get(i).toString());
//                out.newLine();
//            }
//        } catch (IOException e) {
//            Alert alerta = new Alert(Alert.AlertType.ERROR);
//            alerta.setTitle("Error al guardar ticket");
//            alerta.setHeaderText("Error al guardar ticket");
//            alerta.showAndWait();
//        }
//
//        return devuelve;
//    }


}
