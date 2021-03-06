package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.entity.Ciudadano;

public interface ICiudadanoService {
	
	public void saveCiudadano(Ciudadano ciudadano);
	public List<Ciudadano> getCiudadanos();
	public Ciudadano findCiudadano(Long id)throws Exception;
	public Ciudadano getCiudadanoByDni(Long dni)throws Exception;
}
