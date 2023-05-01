#! /bin/sh

set -e

export VAULT_ADDR=http://vault:8200

# give some time for Vault to start and be ready
sleep 3

# login with root token at $VAULT_ADDR
vault login 00000000-0000-0000-0000-000000000000

vault kv put -mount=secret ms-product/default @ms-product.json
vault kv put -mount=secret ms-product/dev @ms-product-dev.json
#vault kv put -mount=secret ms-product/docker @ms-product-docker.json
vault kv put -mount=secret ms-cart/default @ms-cart.json
vault kv put -mount=secret ms-cart/dev @ms-cart-dev.json
#vault kv put -mount=secret ms-cart/docker @ms-cart-docker.json