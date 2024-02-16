package com.feature.pokemon_details.data.mapper

import com.core.network.models.PokemonResponse.PokemonNetwork
import com.feature.pokemon_details.domain.model.PokemonResponse.Ability
import com.feature.pokemon_details.domain.model.PokemonResponse.AbilityX
import com.feature.pokemon_details.domain.model.PokemonResponse.PokemonResponse
import com.feature.pokemon_details.domain.model.PokemonResponse.Stat
import com.feature.pokemon_details.domain.model.PokemonResponse.StatX

fun PokemonNetwork.toDomainPokemon(): PokemonResponse {
    return PokemonResponse(
        this.abilities.map {
            Ability(
                AbilityX(it.ability.name, it.ability.url),
                it.is_hidden,
                it.slot
            )
        },
        this.base_experience,
        this.height,
        this.held_items,
        this.id,
        this.is_default,
        this.location_area_encounters,
        this.name,
        this.order,
        this.past_types,
        this.stats.map { Stat(it.base_stat, it.effort, StatX(it.stat.name, it.stat.url)) },
        this.weight,
    )
}
