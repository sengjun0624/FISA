"use client"

import type React from "react"

import { useState } from "react"
import { Search } from "lucide-react"
import { Input } from "@/components/ui/input"
import { Button } from "@/components/ui/button"
import { Card, CardContent } from "@/components/ui/card"
const API_BASE_URL = process.env.NEXT_PUBLIC_API_BASE_URL || "http://localhost:8080";

interface Owner {
  id: number
  firstName: string
  lastName: string
  address: string
  city: string
  telephone: string
}

interface OwnerSearchProps {
  onSelectOwner: (id: number) => void
}

export default function OwnerSearch({ onSelectOwner }: OwnerSearchProps) {
  const [lastName, setLastName] = useState("")
  const [owners, setOwners] = useState<Owner[]>([])
  const [isLoading, setIsLoading] = useState(false)
  const [error, setError] = useState<string | null>(null)

  const handleSearch = async (e: React.FormEvent) => {
    e.preventDefault()

    if (!lastName.trim()) {
      setError("성(lastName)을 입력해주세요")
      return
    }

    setIsLoading(true)
    setError(null)

    try {
      const response = await fetch(`http://localhost:8080/owners/find?lastName=${encodeURIComponent(lastName)}`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
      })

      if (!response.ok) {
        throw new Error("검색 중 오류가 발생했습니다")
      }

      const data = await response.json()
      setOwners(data)

      if (data.length === 0) {
        setError("검색 결과가 없습니다")
      }
    } catch (err) {
      setError(err instanceof Error ? err.message : "검색 중 오류가 발생했습니다")
    } finally {
      setIsLoading(false)
    }
  }

  return (
    <div className="space-y-6">
      <form onSubmit={handleSearch} className="space-y-4">
        <div className="relative">
          <Search className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400" />
          <Input
            type="text"
            placeholder="소유자의 성(lastName)으로 검색"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
            className="pl-10 h-12 rounded-xl border-gray-200 focus:border-[#3182F6] focus:ring-[#3182F6]"
          />
        </div>

        <Button
          type="submit"
          disabled={isLoading}
          className="w-full h-12 rounded-xl bg-[#3182F6] hover:bg-[#1b64da] text-white font-medium"
        >
          {isLoading ? "검색 중..." : "검색하기"}
        </Button>
      </form>

      {error && <div className="p-4 text-center text-red-500 bg-red-50 rounded-xl">{error}</div>}

      {owners.length > 0 && (
        <div className="space-y-3">
          <h2 className="text-lg font-medium text-[#333D4B]">검색 결과</h2>
          {owners.map((owner) => (
            <Card
              key={owner.id}
              className="overflow-hidden hover:shadow-md transition-shadow cursor-pointer"
              onClick={() => onSelectOwner(owner.id)}
            >
              <CardContent className="p-4">
                <div className="flex justify-between items-center">
                  <div>
                    <h3 className="font-medium text-[#333D4B]">
                      {owner.lastName} {owner.firstName}
                    </h3>
                    <p className="text-sm text-gray-500">
                      {owner.address}, {owner.city}
                    </p>
                  </div>
                  <div className="text-sm text-gray-500">{owner.telephone}</div>
                </div>
              </CardContent>
            </Card>
          ))}
        </div>
      )}
    </div>
  )
}

