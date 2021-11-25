package br.com.zup.edu;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum TipoIngresso {

    INTEIRA {
        @Override
        public BigDecimal aplica(BigDecimal valor) {

            return valor;
        }
    },

    MEIA_ENTRADA {
        @Override
        public BigDecimal aplica(BigDecimal valor) {

            return valor.divide(new BigDecimal("2.0"), RoundingMode.HALF_UP);
        }
    },

    CORTESIA {
        @Override
        public BigDecimal aplica(BigDecimal valor) {

            return BigDecimal.ZERO;
        }
    },

    AMIGOS_DA_PAULA {
        @Override
        public BigDecimal aplica(BigDecimal valor) {

            return valor.multiply(new BigDecimal("0.25"));
        }
    },

    ALUNOS_OT9 {
        @Override
        public BigDecimal aplica(BigDecimal valor) {
            return valor.multiply(new BigDecimal("0.1"));
        }

    };

    protected abstract BigDecimal aplica(BigDecimal valor);

    public BigDecimal aplicaDesconto(BigDecimal valor) {
        if (valor == null) {
            throw new IllegalArgumentException("O valor do ingresso não pode ser nulo");
        }

        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor do ingresso não pode ser negativo");
        }

        return aplica(valor);
    }

}
