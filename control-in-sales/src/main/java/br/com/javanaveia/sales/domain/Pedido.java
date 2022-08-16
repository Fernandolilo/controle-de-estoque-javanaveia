package br.com.javanaveia.sales.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.javanaveia.sales.domain.enums.StatusPedido;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime instante;

	private Integer status;

	private Long idProduto;
	private Long idCliente;
	private Long idEndereco;

	@ManyToOne()
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens = new ArrayList<>();

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Cliente> clientes = new ArrayList<>();

	public Pedido() {
	}

	public Pedido(Long id, LocalDateTime instante, StatusPedido status, Long idProduto, Long idCliente, Long idEndereco,
			Empresa empresa) {
		this.id = id;
		this.instante = instante;
		this.status = (status == null) ? null : status.getCod();
		this.idProduto = idProduto;
		this.idCliente = idCliente;
		this.idEndereco = idEndereco;
		this.empresa = empresa;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the instante
	 */
	public LocalDateTime getInstante() {
		return instante;
	}

	/**
	 * @param instante the instante to set
	 */
	public void setInstante(LocalDateTime instante) {
		this.instante = instante;
	}

	/**
	 * @return the status
	 */
	public StatusPedido getStatus() {
		return StatusPedido.toEnum(status);
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusPedido status) {
		this.status = status.getCod();
	}

	/**
	 * @return the idProduto
	 */
	public Long getIdProduto() {
		return idProduto;
	}

	/**
	 * @param idProduto the idProduto to set
	 */
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	/**
	 * @return the idCliente
	 */
	public Long getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * @return the idEndereco
	 */
	public Long getIdEndereco() {
		return idEndereco;
	}

	/**
	 * @param idEndereco the idEndereco to set
	 */
	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @return the itens
	 */
	public List<ItemPedido> getItens() {
		return itens;
	}

	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, idProduto, instante, itens);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id) && Objects.equals(idProduto, other.idProduto)
				&& Objects.equals(instante, other.instante) && Objects.equals(itens, other.itens);
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("Numero de Pedido: ");
		builder.append(getId());
		builder.append(", Instante: ");
		builder.append(sdf.format(getInstante()));
		builder.append("Id do cliente: ");
		builder.append(getIdCliente());
		builder.append("\nDetalhes: \n");
		for (ItemPedido ip : getItens()) {
			builder.append(ip.toString());
		}
		return builder.toString();

	}
}
